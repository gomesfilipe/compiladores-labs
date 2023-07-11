package code;

import static code.Instruction.INSTR_MEM_SIZE;
import static code.OpCode.ADDf;
import static code.OpCode.ADDi;
import static code.OpCode.B2Ss;
import static code.OpCode.BOFb;
import static code.OpCode.CALL;
import static code.OpCode.CATs;
import static code.OpCode.DIVf;
import static code.OpCode.DIVi;
import static code.OpCode.EQUf;
import static code.OpCode.EQUi;
import static code.OpCode.EQUs;
import static code.OpCode.HALT;
import static code.OpCode.I2Ss;
import static code.OpCode.JUMP;
import static code.OpCode.LDIf;
import static code.OpCode.LDIi;
import static code.OpCode.LDWf;
import static code.OpCode.LDWi;
import static code.OpCode.LTHf;
import static code.OpCode.LTHi;
import static code.OpCode.LTHs;
import static code.OpCode.MULf;
import static code.OpCode.MULi;
import static code.OpCode.OROR;
import static code.OpCode.R2Ss;
import static code.OpCode.STWf;
import static code.OpCode.STWi;
import static code.OpCode.SUBf;
import static code.OpCode.SUBi;
import static code.OpCode.WIDf;
import static typing.Type.BOOL_TYPE;
import static typing.Type.INT_TYPE;
import static typing.Type.REAL_TYPE;

import ast.AST;
import ast.ASTBaseVisitor;
import tables.StrTable;
import tables.VarTable;
import typing.Type;

/*
 * Visitador da AST para geração básica de código. Funciona de
 * forma muito similar ao interpretador do laboratório anterior,
 * mas agora estamos trabalhando com um ambiente de execução
 * com código de 3 endereços. Isto quer dizer que não existe mais
 * pilha e todas as operações são realizadas via registradores.
 *
 * Note que não há uma área de memória de dados no código abaixo.
 * Esta área fica agora na TM, que é a "arquitetura" de execução.
 */
public final class CodeGen extends ASTBaseVisitor<Integer> {

	private final Instruction code[]; // Code memory
	private final StrTable st;
	private final VarTable vt;
	private OpCode BOTb;

	// Contadores para geração de código.
	// Próxima posição na memória de código para emit.
	private static int nextInstr;
	// Número de registradores temporários já utilizados.
	// Usamos um valor arbitrário, mas depois seria necessário
	// fazer o processo de alocação de registradores. Isto está
	// fora do escopo da disciplina.
	private static int intRegsCount;
	private static int floatRegsCount;

	public CodeGen(StrTable st, VarTable vt) {
		this.code = new Instruction[INSTR_MEM_SIZE];
		this.st = st;
		this.vt = vt;
	}

	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
		intRegsCount = 0;
		floatRegsCount = 0;
	    dumpStrTable();
	    visit(root);
	    emit(HALT);
	    dumpProgram();
	}

	// ----------------------------------------------------------------------------
	// Prints ---------------------------------------------------------------------

	void dumpProgram() {
	    for (int addr = 0; addr < nextInstr; addr++) {
	    	System.out.printf("%s\n", code[addr].toString());
	    }
	}

	void dumpStrTable() {
	    for (int i = 0; i < st.size(); i++) {
	        System.out.printf("SSTR %s\n", st.get(i));
	    }
	}

	// ----------------------------------------------------------------------------
	// Emits ----------------------------------------------------------------------

	private void emit(OpCode op, int o1, int o2, int o3) {
		Instruction instr = new Instruction(op, o1, o2, o3);
		// Em um código para o produção deveria haver uma verificação aqui...
	    code[nextInstr] = instr;
	    nextInstr++;
	}

	private void emit(OpCode op) {
		emit(op, 0, 0, 0);
	}

	private void emit(OpCode op, int o1) {
		emit(op, o1, 0, 0);
	}

	private void emit(OpCode op, int o1, int o2) {
		emit(op, o1, o2, 0);
	}

	private void backpatchJump(int instrAddr, int jumpAddr) {
	    code[instrAddr].o1 = jumpAddr;
	}

	private void backpatchBranch(int instrAddr, int offset) {
	    code[instrAddr].o2 = offset;
	}

	// ----------------------------------------------------------------------------
	// AST Traversal --------------------------------------------------------------

	private int newIntReg() {
		return intRegsCount++;
	}

	private int newFloatReg() {
		return floatRegsCount++;
	}

	// Funcionamento dos visitadores abaixo deve ser razoavelmente explicativo
	// neste final do curso...

	@Override
	protected Integer visitAssign(AST node) {

		int register = visit(node.getChild(1)); // expr
		int index = node.getChild(0).intData;

		if(node.getChild(0).type == Type.INT_TYPE) {
			emit(STWi,index,register);		
		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			emit(STWf,index,register);
		} else if(node.getChild(0).type == Type.STR_TYPE) {
			emit(STWi,index,register);
		}else if(node.getChild(0).type == Type.BOOL_TYPE) {
			emit(STWi,index,register);
		}
	    return -1; // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visitEq(AST node) {
		int register1 = visit(node.getChild(0)); // expr
		int register2 = visit(node.getChild(1)); // expr
		
		if(node.getChild(1).type  == Type.INT_TYPE) {
			int resul_register = newIntReg();
			emit(EQUi,resul_register,register1,register2);
			return resul_register;
		} else if(node.getChild(1).type  == Type.REAL_TYPE) {
			int resul_register = newIntReg();
			emit(EQUf,resul_register,register1,register2);
			return resul_register;
		}else if(node.getChild(1).type == Type.STR_TYPE) {
			int resul_register = newIntReg();
			emit(EQUs,resul_register,register1,register2);
			return resul_register;
		}
        return -1; // FIXME Return a proper value here.
	}

	@Override
	protected Integer visitBlock(AST node) {
		for (int i = 0; i < node.getChildrenSize(); i++) {
			visit(node.getChild(i));
		}
		return -1; // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visitBoolVal(AST node) {
		int x = newIntReg();
	    int c = node.intData;
	    emit(LDIi, x, c);
	    return x;
	}

	@Override
	protected Integer visitIf(AST node) {
		int register1 = visit(node.getChild(0)); // expr
		
		int atualiza = CodeGen.nextInstr;
		emit(BOFb, register1, 0); // valor qualquer, será atualizado no back-patching 
		
		visit(node.getChild(1));
		int pc_else = CodeGen.nextInstr;
		
		backpatchBranch(atualiza,pc_else-atualiza); 

		if(node.getChildrenSize() == 3) { // tem else
			visit(node.getChild(2));
		}

		return -1;
	}

	@Override
	protected Integer visitIntVal(AST node) {
		int x = newIntReg();
		emit(LDIi, x, node.intData);
	    return x;
	}

	@Override
	protected Integer visitLt(AST node) {

		int register1 = visit(node.getChild(0)); // expr
		int register2 = visit(node.getChild(1)); // expr
		
		if(node.getChild(1).type  == Type.INT_TYPE) {
			int resul_register = newIntReg();
			emit(LTHi,resul_register,register1,register2);
			return resul_register;
		} else if(node.getChild(1).type  == Type.REAL_TYPE) {
			int resul_register = newIntReg();
			emit(LTHf,resul_register,register1,register2);
			return resul_register;
		}else if(node.getChild(1).type == Type.STR_TYPE) {
			int resul_register = newIntReg();
			emit(LTHs,resul_register,register1,register2);
			return resul_register;
		}
        return -1; // FIXME Return a proper value here.
	}

	@Override
	protected Integer visitMinus(AST node) {

		int register1 = visit(node.getChild(0));
		int register2 = visit(node.getChild(1));
		
		
		if(node.type == Type.INT_TYPE) {
			int resul_register = newIntReg();
			emit(SUBi,resul_register,register1,register2);
			return resul_register;
		} else if(node.type == Type.REAL_TYPE) {
			int resul_register = newFloatReg();
			emit(SUBf,resul_register,register1,register2);	
			return resul_register;
		}
		return -1; // FIXME Return a proper value here.
	}

	@Override
	protected Integer visitOver(AST node) {
		
		int register1 = visit(node.getChild(0));
		int register2 = visit(node.getChild(1));
		
		if(node.type == Type.INT_TYPE) {
			int resul_register = newIntReg();
			emit(DIVi,resul_register,register1,register2);
			return resul_register;
		} else if(node.type == Type.REAL_TYPE) {
			int resul_register = newFloatReg();
			emit(DIVf,resul_register,register1,register2);	
			return resul_register;
		}
		return -1; // FIXME Return a proper value here.
	}

	@Override
	protected Integer visitPlus(AST node) {

		int register1 = visit(node.getChild(0));
		int register2 = visit(node.getChild(1));
		
		if(node.type == Type.INT_TYPE) {
			int resul_register = newIntReg();
			emit(ADDi,resul_register,register1,register2);
			return resul_register;
		} else if(node.type == Type.REAL_TYPE) {
			int resul_register = newFloatReg();
			emit(ADDf,resul_register,register1,register2);	
			return resul_register;
		} else if(node.type == Type.STR_TYPE) {
			int resul_register = newIntReg();
			emit(CATs,resul_register, register1,register2);
			return resul_register;
		} else if(node.type == Type.BOOL_TYPE) {
			int resul_register = newIntReg();
			emit(OROR,resul_register,register1,register2);
			return resul_register;
		}
		return -1; // FIXME Return a proper value here.
	}

	@Override
	protected Integer visitProgram(AST node) {
		visit(node.getChild(0)); // var_list
		visit(node.getChild(1)); // block
	    return -1;  // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visitRead(AST node) {

		Type type = node.getChild(0).type;
		int addr = 	node.getChild(0).intData;

		if (type == Type.INT_TYPE){
			int register = newIntReg();
			emit(CALL,0,register);
			emit(STWi,addr,register);
			return -1; 

		}else if(type == Type.REAL_TYPE){
			int register = newFloatReg();
			emit(CALL,1,register);
			emit(STWf,addr,register);
			return -1; 
			
		}else if(type == Type.STR_TYPE){
			int register = newIntReg();
			emit(CALL,3,register);
			emit(STWi,addr,register);
			return -1; 

		}else if(type == Type.BOOL_TYPE){
			int register = newIntReg();
			emit(CALL,2,register);
			emit(STWi,addr,register);
			return -1; 
		}
		
	    return -1;  // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visitRealVal(AST node) {
		int x = newFloatReg();
	    // We need to read as an int because the TM cannot handle floats directly.
	    // But we have a float stored in the AST, so we just convert it as an int
	    // and magically we have a float encoded as an int... :P
	    int c = Float.floatToIntBits(node.floatData);
	    emit(LDIf, x, c);
	    return x;
	}

	@Override
	protected Integer visitRepeat(AST node) {
		int pc_repeat = CodeGen.nextInstr; 
		visit(node.getChild(0)); // block
		int registrador1 = visit(node.getChild(1)); // expr
		emit(BOFb, registrador1, pc_repeat-CodeGen.nextInstr);
		return -1;
	}

	@Override
	protected Integer visitStrVal(AST node) {
		int x = newIntReg();
	    int c = node.intData;
	    emit(LDIi, x, c);
	    return x;
	}

	@Override
	protected Integer visitTimes(AST node) {
		
		int register1 = visit(node.getChild(0));
		int register2 = visit(node.getChild(1));

		if(node.type == Type.INT_TYPE) {
			int resul_register = newIntReg();
			emit(MULi, resul_register, register1, register2);
			return resul_register;
		} else if(node.type == Type.REAL_TYPE) {
			int resul_register = newFloatReg();
			emit(MULf,resul_register,register1,register2);	
			return resul_register;
		}
		return -1;

	}

	@Override
	protected Integer visitVarDecl(AST node) {
		// Nothing to do here.
	    return -1;  // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visitVarList(AST node) {
		// Nothing to do here.
	    return -1;  // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visitVarUse(AST node) {
		
		if(node.type == Type.BOOL_TYPE){
			int x = newIntReg();
			emit(LDWi,x,node.intData);
			return x;

		}else if (node.type == Type.INT_TYPE){
			int x = newIntReg();
			emit(LDWi,x,node.intData);
			return x;
		}else if (node.type == Type.REAL_TYPE){
			int x = newFloatReg();
			emit(LDWf,x,node.intData);
			return x;
			
		}else if (node.type == Type.STR_TYPE){
			int x = newIntReg();
			emit(LDWi,x,node.intData);
			return x;
		}
		return -1; // FIXME Return a proper value here.
	}


	@Override
	protected Integer visitWrite(AST node) {

		int register_value = visit(node.getChild(0));
	
		if(node.getChild(0).type == Type.INT_TYPE) {
			emit(CALL, 4,register_value);
			return -1;

		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			emit(CALL, 5,register_value);
			return -1;

		} else if(node.getChild(0).type == Type.BOOL_TYPE) {
			emit(CALL, 6,register_value);
			return -1;

		} else if(node.getChild(0).type == Type.STR_TYPE) {
			emit(CALL, 7,register_value);
			return -1;
		}
		
		return -1;
	}

	@Override
	protected Integer visitB2I(AST node) {
		return visit(node.getChild(0));
	}

	@Override
	protected Integer visitB2R(AST node) {
		int register_int = visit(node.getChild(0));
		int register = newFloatReg();
		emit(WIDf,register,register_int);
		return register;
	}

	@Override
	protected Integer visitB2S(AST node) {
		int x = newIntReg();
	    int y = visit(node.getChild(0));
	    emit(B2Ss, x, y);
	    return x;
	}

	@Override
	protected Integer visitI2R(AST node) {
		int register_int = visit(node.getChild(0));
		int register = newFloatReg();
		emit(WIDf,register,register_int);
		return register;
	}

	@Override
	protected Integer visitI2S(AST node) {
		int x = newIntReg();
	    int y = visit(node.getChild(0));
	    emit(I2Ss, x, y);
	    return x;
	}

	@Override
	protected Integer visitR2S(AST node) {
		int x = newIntReg();
	    int y = visit(node.getChild(0));
	    emit(R2Ss, x, y);
	    return x;
	}

}
