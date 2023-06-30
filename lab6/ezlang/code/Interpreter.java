package code;

import static typing.Type.INT_TYPE;
import static typing.Type.REAL_TYPE;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;

import ast.AST;
import ast.ASTBaseVisitor;
import tables.StrTable;
import tables.VarTable;
import typing.Type;

/*
 * Interpretador de código para EZLang, implementado como
 * um visitador da AST gerada pelo front-end. Tipo genérico
 * foi instanciado para Void porque a gente não precisa de
 * um valor de retorno na visitação. Para o gerador de código
 * do próximo laboratório isso vai mudar.
 *
 * Para rodar, chame o método 'execute' da superclasse.
 */
public class Interpreter extends ASTBaseVisitor<Void> {

	// Tudo privado e final para simplificar.
	private final DataStack stack;
	private final Memory memory;
	private final StrTable st;
	private final VarTable vt;
	private final Scanner in;  // Para leitura de stdin

	// Construtor basicão.
	public Interpreter(StrTable st, VarTable vt) {
		this.stack = new DataStack();
		this.memory = new Memory(vt);
		this.st = st;
		this.vt = vt;
		this.in = new Scanner(System.in);
	}

	// -------------------------------------------------------
	// Daqui para frente são os métodos especializados de cada
	// nó. O código deve ser mais ou menos auto-explicativo.
	// Estou assumindo que nessa altura de tudo você já está
	// ninja dos caminhamentos em árvores...

	// TODO

// 	ASSIGN_NODE: Executa recursivamente o filho contendo a express ̃ao `a direita da atri-
// bui ̧c ̃ao, para deixar o valor a ser atribu ́ıdo `a vari ́avel no topo da pilha. A seguir, desempi-
// lha esse valor e armazena o novo valor da vari ́avel, respeitando os tipos (inteiro ou real).
	@Override // X = 2
	protected Void visitAssign(AST node) {
		visit(node.getChild(1)); // expr
		int index = node.getChild(0).intData;
		
		float resultFloat;
		int resultInt;

		if(node.getChild(0).type == Type.INT_TYPE) {
			resultInt = stack.popi();
			memory.storei(index, resultInt);
		
		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			resultFloat = stack.popf();
			memory.storef(index, resultFloat);

		} else if(node.getChild(0).type == Type.STR_TYPE) {
			resultInt = stack.popi();
			memory.storei(index, resultInt);
			
		}else if(node.getChild(0).type == Type.BOOL_TYPE) {
			resultInt = stack.popi();
			memory.storei(index, resultInt);
		}

		return null;
	}

	// TODO
	@Override
	protected Void visitEq(AST node) {
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STR_TYPE) {
			int index1 = stack.popi();
			int index2 = stack.popi();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			bool_result = str1.equals(str2);
		} else {
			bool_result = stack.popi() == stack.popi();
		}
		
		if(bool_result == true) {
				stack.pushi(1);	

		} else if(bool_result == false) {
				stack.pushi(0);	
		}

		return null;
	}

	// TODO
	@Override
	protected Void visitBlock(AST node) {
		for (int i = 0; i < node.getChildrenSize(); i++) {
			visit(node.getChild(i));
		}
		
		return null;
	}

	// TODO
	@Override
	protected Void visitBoolVal(AST node) {
		stack.pushi(node.intData);
		return null;
	}

	// TODO
	@Override
	protected Void visitIf(AST node) {
    visit(node.getChild(0));
		int result = stack.popi();

		if(result == 1) {
			visit(node.getChild(1));

		} else if(result == 0 && node.getChildrenSize() == 3) {
			visit(node.getChild(2));
		}

		return null;
	}

	// TODO
	@Override
	protected Void visitIntVal(AST node) {
		stack.pushi(node.intData);
		return null;
	}

	// TODO
	@Override
	protected Void visitLt(AST node) {
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STR_TYPE) {
			int index1 = stack.popi();
			int index2 = stack.popi();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			int int_result = str1.compareTo(str2);
			
			if(int_result == -1) {
				bool_result = true;
			
			} else {
				bool_result = false;
			}

		} else {
			bool_result = stack.popi() < stack.popi();
		}

		if(bool_result == true){
			stack.pushi(1);
		}else if(bool_result == false){
			stack.pushi(0);
		}
		
		return null;
	}

	// TODO
	@Override
	protected Void visitMinus(AST node) {
		visit(node.getChild(1));
		visit(node.getChild(0));
		
		int resultInt;
		float floatInt;

		if(node.type == Type.INT_TYPE) {
			int overResult = stack.popi() - stack.popi();
			stack.pushi(overResult);
		
		} else if(node.type == Type.REAL_TYPE) {
			float overResult = stack.popf() - stack.popf();
			stack.pushf(overResult);
		}
		return null;
	}

	// TODO
	@Override
	protected Void visitOver(AST node) {
		visit(node.getChild(1));
		visit(node.getChild(0));

		if(node.type == Type.INT_TYPE) {
			int overResult = stack.popi() / stack.popi();
			stack.pushi(overResult);
		} else if(node.type == Type.REAL_TYPE) {
			float overResult = stack.popf() / stack.popf();
			stack.pushf(overResult);
		}

		return null;
	}

	// TODO
	@Override
	protected Void visitPlus(AST node) {
		visit(node.getChild(1));
		visit(node.getChild(0));
		
		int resultInt;
		float floatInt;

		if(node.type == Type.INT_TYPE) {		

			int plusResult = stack.popi() + stack.popi();
			stack.pushi(plusResult);
		
		} else if(node.type == Type.REAL_TYPE) {
			float plusResult = stack.popf() + stack.popf();
			stack.pushf(plusResult);
		
		} else if(node.type == Type.STR_TYPE) {
			int indexStr1 = stack.popi();
			int indexStr2 = stack.popi();

			String str1 = st.get(indexStr1);
			String str2 = st.get(indexStr2);

			str1 = str1.substring(1, str1.length() - 1);
			str2 = str2.substring(1, str2.length() - 1);

			String concatResult = str1.concat(str2);
			int indexConcat = st.addStr("\"" + concatResult + "\"");
			stack.pushi(indexConcat); 

		} else if(node.type == Type.BOOL_TYPE) {

			if(stack.popi() == 1 || stack.popi() == 1){
				stack.pushi(1);
			}else{
				stack.pushi(0);
			}
		}
		return null;
	}

	@Override
	protected Void visitProgram(AST node) {
		visit(node.getChild(0)); // run var_list
		visit(node.getChild(1)); // run block
		in.close(); // Fim do programa, não precisa mais de ler de stdin.
		return null;
	}

	// TODO
	@Override
	protected Void visitRead(AST node) {
		Type type = node.getChild(0).type;
		int addr = 	node.getChild(0).intData;

		int intValue;
		float floatValue;

		if (type == Type.INT_TYPE){
			readInt(addr);

		}else if(type == Type.REAL_TYPE){
			readReal(addr);

		}else if(type == Type.STR_TYPE){
			readStr(addr);

		}else if(type == Type.BOOL_TYPE){
			readBool(addr);
		}
		
		return null;
	}

	// Funções auxiliares para implementar 'visitRead'.

	private Void readInt(int varIdx) {
		System.out.printf("read (int): ");
		int value = in.nextInt();
		System.out.println(value);
		memory.storei(varIdx, value);
		return null; 
	}

	private Void readReal(int varIdx) {
		System.out.printf("read (real): ");
		float value = in.nextFloat();
		System.out.println(value);
		memory.storef(varIdx, value);
		return null; 
	}

	private Void readBool(int varIdx) {
		int value;
	    do {
	        System.out.printf("read (bool - 0 = false, 1 = true): ");
	        value = in.nextInt();
	    } while (value != 0 && value != 1);
		if(value == 1){
			System.out.println("true");
		}else{
			System.out.println("false");
		}

		memory.storei(varIdx, value);
		return null; 
	}

	private Void readStr(int varIdx) {
		System.out.printf("read (str): ");
		String s = in.next();
		int strIdx = st.addStr(s);
		memory.storei(varIdx, strIdx);
		System.out.println(s);
		return null;
	}

	// TODO
	@Override
	protected Void visitRealVal(AST node) {
		stack.pushf(node.floatData);
		return null;
	}

	// TODO
	@Override
	protected Void visitRepeat(AST node) {
		while(true) {
			visit(node.getChild(0)); // block
			visit(node.getChild(1)); // expr

			int bool_result = stack.popi();

			if(bool_result == 1) {
				break;
			}
		}
		
		return null;
	}

	@Override
	protected Void visitStrVal(AST node) {
		stack.pushi(node.intData);
		return null;
	}

	// TODO
	@Override
	protected Void visitTimes(AST node) {
		visit(node.getChild(1));
		visit(node.getChild(0));
		
		int resultInt;
		float floatInt;

		if(node.type == Type.INT_TYPE) {
			int overResult = stack.popi() * stack.popi();
			stack.pushi(overResult);
		} else if(node.type == Type.REAL_TYPE) {
			float overResult = stack.popf() * stack.popf();
			stack.pushf(overResult);
		}

		return null;
	}

	@Override
	protected Void visitVarDecl(AST node) {
		// Nothing to do.
		return null;
	}

	@Override
	protected Void visitVarList(AST node) {
		// Nothing to do.
		return null;
	}

	// TODO
	@Override
	protected Void visitVarUse(AST node) {
		Type type = node.type;
		int intValue;
		float floatValue;
		
		if(type == Type.BOOL_TYPE){
			intValue = memory.loadi(node.intData);
			stack.pushi(intValue);

		}else if (type == Type.INT_TYPE){
			intValue = memory.loadi(node.intData);
			stack.pushi(intValue);

		}else if (type == Type.REAL_TYPE){
			floatValue = memory.loadf(node.intData);
			stack.pushf(floatValue);
			
		}else if (type == Type.STR_TYPE){
			intValue = memory.loadi(node.intData);
			stack.pushi(intValue);
		}
		
		return null;
	}

	// TODO
	@Override
	protected Void visitWrite(AST node) {
		visit(node.getChild(0));
	
		if(node.getChild(0).type == Type.INT_TYPE) {
			writeInt();

		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			writeReal();

		} else if(node.getChild(0).type == Type.BOOL_TYPE) {
			writeBool();

		} else if(node.getChild(0).type == Type.STR_TYPE) {
			writeStr();
		}
		
		return null;
	}

	// Funções auxiliares para implementar 'visitWrite'.

	private Void writeInt() {
		System.out.println(stack.popi());
		return null;
	}

	private Void writeReal() {
		System.out.println(stack.popf());
		return null;
	}

	private Void writeBool() {
		if (stack.popi() == 0) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}
		return null;
	}

	private Void writeStr() {
		int strIdx = stack.popi(); // String pointer
		String originalStr = st.get(strIdx);
		String unescapedStr = unescapeStr(originalStr);
		System.out.print(unescapedStr);
		return null;
	}

	// Função auxiliar para converter a string com escapes.
	// Há várias formas de se fazer isso em Java mas preferi
	// deixar assim para não precisar de bibliotecas ou de uma
	// versão do Java mais recente.
	// Se você preferir, pode usar:
	// org.apache.commons.lang.StringEscapeUtils.unescapeJava()
	// ou
	// String.translateEscapes(), disponível a partir do Java 15.
	private String unescapeStr(String originalStr) {
		StreamTokenizer parser = new StreamTokenizer(new StringReader(originalStr));
		String unescapedStr = "";
		try {
		    parser.nextToken();
		    if (parser.ttype == '"') {
			    unescapedStr = parser.sval;
		    } else {
			  unescapedStr = "ERROR at string conversion!";
		    }
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		return unescapedStr;
	}

	// TODO
	@Override
	protected Void visitB2I(AST node) {
		visit(node.getChild(0)); // já vem certo
		return null;
	}

	// TODO
	@Override
	protected Void visitB2R(AST node) {
		visit(node.getChild(0));
		float boolVal = (float) stack.popi();
		stack.pushf(boolVal);
		return null;
	}

	@Override
	protected Void visitB2S(AST node) {
		visit(node.getChild(0));
		String s;
		if (stack.popi() == 0) {
			s = '"' + Boolean.toString(false) + '"';
		} else {
			s = '"' + Boolean.toString(true) + '"';
		}
		stack.pushi(st.addStr(s));
		return null;
	}

	// TODO
	@Override
	protected Void visitI2R(AST node) {
		visit(node.getChild(0)); // já vem certo
		float intVal = (float) stack.popi();
		stack.pushf(intVal);
		return null;
	}

	@Override
	protected Void visitI2S(AST node) {
		visit(node.getChild(0));
		String s = '"' + Integer.toString(stack.popi()) + '"';
		stack.pushi(st.addStr(s));
		return null;
	}

	@Override
	protected Void visitR2S(AST node) {
		visit(node.getChild(0));
		String s = '"' + Float.toString(stack.popf()) + '"';
		stack.pushi(st.addStr(s));
		return null;
	}
}
