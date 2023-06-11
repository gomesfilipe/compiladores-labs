// import parser.EZParser;
import tables.StrTable;
import tables.VarTable;
import typing.Type;

import parser.EZParser;
import parser.EZParserBaseVisitor;

import ast.AST;
import ast.NodeKind;

public class Visitor extends EZParserBaseVisitor<AST>{
    private StrTable strTable = new StrTable();
    private VarTable varTable = new VarTable();
    private Type currentType;

    @Override
    public AST visitStr_val(EZParser.Str_valContext ctx) {
        strTable.add(ctx.STR_VAL().getText());
        AST ast = new AST(NodeKind.STR_VAL_NODE, strTable.size() - 1, Type.STR_TYPE);
        return ast;
    }

    public StrTable getStrTable() {
        return this.strTable;
    }

    public VarTable getVarTable() {
        return this.varTable;
    }

    @Override
    public AST visitProgram(EZParser.ProgramContext ctx) {
        AST ast = new AST(NodeKind.PROGRAM_NODE,0,Type.NO_TYPE);
        ast.addChild(visit(ctx.varssect()));
        ast.addChild(visit(ctx.stmtsect()));

        return ast;
    }

    @Override 
    public AST visitVarssect(EZParser.VarssectContext ctx) {
        
        AST ast = new AST(NodeKind.VAR_LIST_NODE,0,Type.NO_TYPE);

        int tam  = ctx.vardecl().size();
        for(int i = 0 ; i< tam; i ++)
        {
            ast.addChild(visit(ctx.vardecl(i)));
        }
        return ast;
    }

    @Override 
    public AST visitVardecl(EZParser.VardeclContext ctx) {
        AST ast;
        
        this.handleVarTableVardecl(ctx);

        ast = new AST(NodeKind.VAR_DECL_NODE,varTable.getSize()-1, varTable.getType(varTable.getSize()-1));
        
        return ast;
    }

    private Void handleVarTableVardecl(EZParser.VardeclContext ctx) {
        if(varTable.lookupVar(ctx.ID().getText()) != -1) { // Existe, disparar erro!
            // System.out.println("Variável " + ctx.ID().getText() + "redeclarada.");
            System.out.println("SEMANTIC ERROR (9): variable '" + ctx.ID().getText() + "' already declared at line " + this.varTable.getLine(this.varTable.lookupVar(ctx.ID().getText())) + ".");
            System.exit(1);
        } else {
            visit(ctx.typespec());
            varTable.addVar(ctx.ID().getText(), ctx.getStart().getLine(), this.currentType);
        }
        return null;
    }

	@Override 
    public AST visitStmtsect(EZParser.StmtsectContext ctx){  
        AST ast = new AST(NodeKind.BLOCK_NODE,0,Type.NO_TYPE);

        int tam  = ctx.stmt().size();
        for(int i = 0 ; i< tam; i ++)
        {
            ast.addChild(visit(ctx.stmt(i)));
        }
        return ast;
    }

    @Override
    public AST visitBool(EZParser.BoolContext ctx) {
        this.currentType = Type.BOOL_TYPE;
        return null;
    }

    @Override
    public AST visitInt(EZParser.IntContext ctx) {
        this.currentType = Type.INT_TYPE;
        return null;

    }

    @Override
    public AST visitReal(EZParser.RealContext ctx) {
        this.currentType = Type.REAL_TYPE;
        return null;
    }

    @Override
    public AST visitString(EZParser.StringContext ctx) {
        this.currentType = Type.STR_TYPE;
        return null;
    }

    @Override 
    public AST visitAssignstmt(EZParser.AssignstmtContext ctx) {
        this.handleIdInMain(ctx.ID().getText());
        Type typeID = varTable.getTypeByName(ctx.ID().getText());


        AST astExpr = visit(ctx.expr());
        
        checkResultAtributionType(typeID, astExpr.type, ctx.getStart().getLine(), ":=");
        
        AST ast = new AST(NodeKind.ASSIGN_NODE, 0, Type.NO_TYPE);

        AST left = new AST(NodeKind.VAR_USE_NODE,varTable.lookupVar(ctx.ID().getText()), typeID);
        ast.addChild(left);
        
        // Se precisa fazer cast
        if(astExpr.type == Type.INT_TYPE && typeID == Type.REAL_TYPE) {
            ast.addChild(insertConvertion(astExpr, Type.REAL_TYPE, NodeKind.I2R_NODE));
        } else {
            ast.addChild(astExpr);
        }

        return ast;
    }

    private Boolean checkResultAtributionType(Type type1, Type type2, int line, String op) {
        Boolean result = this.getResultAtributionType(type1, type2);
        if(!result) {
            System.out.println("SEMANTIC ERROR (" + line + "): incompatible types for operator '" + op + "', LHS is '" + type1 + "' and RHS is '" + type2 + "'." );
            System.exit(7);
        }
        return result;
    }

    private Boolean getResultAtributionType(Type type1, Type type2) {
        if(type1 == type2) {
            return true;
        } 

        if(type1 == Type.REAL_TYPE && type2 == Type.INT_TYPE) {
            return true;
        }

        return false;
    }

    @Override 
    public AST visitReadstmt(EZParser.ReadstmtContext ctx) {
        AST ast = new AST(NodeKind.READ_NODE,0,Type.NO_TYPE);
        Type type = this.handleIdInMain(ctx.ID().getText());

        AST child = new AST(NodeKind.VAR_USE_NODE,varTable.lookupVar(ctx.ID().getText()),type);
        ast.addChild(child);
        
        return ast; 
    }
    
    @Override  
    public AST visitWritestmt(EZParser.WritestmtContext ctx) {
        AST ast = new AST(NodeKind.WRITE_NODE, 0 ,Type.NO_TYPE);
        AST child = visit(ctx.expr());
        ast.addChild(child);
        return ast;
    }

    @Override 
    public AST visitId(EZParser.IdContext ctx) { 
        this.handleIdInMain(ctx.ID().getText());
        Type typeID = varTable.getTypeByName(ctx.ID().getText());
        AST id = new AST(NodeKind.VAR_USE_NODE, varTable.lookupVar(ctx.ID().getText()), typeID);
        return id;
    }

    private Type handleIdInMain(String id) {
        if(varTable.lookupVar(id) == -1) { // Não existe, disparar erro!
            System.out.println("SEMANTIC ERROR (9): variable '" + id + "' was not declared.");
            System.exit(1);
        }

        return this.varTable.getTypeByName(id);
    }

    private boolean makeAstOperation(String op,AST dad,AST left, AST right, Type type){
        //verificar se precisa de conversão
        NodeKind leftConversion = getNodeKindConversion(op, left.type, right.type);
        System.out.println(op + " " + leftConversion);
        NodeKind rightConversion = getNodeKindConversion(op, right.type, left.type);
        System.out.println(op + " " + rightConversion);
        
        if(leftConversion == null && rightConversion == null) {
            // sem nó de conversão
            dad.addChild(left);
            dad.addChild(right);
        } else if(leftConversion != null && rightConversion == null) {
            // nó de conversão a esquerda
            dad.addChild(insertConvertion(left, type, leftConversion));
            dad.addChild(right);

        } else if(leftConversion == null && rightConversion != null) {
            // nó de conversão a direita
            dad.addChild(left);
            dad.addChild(insertConvertion(right, type, rightConversion));

        } else {
           return false;
        }
        return true;
    }

    @Override 
    public AST visitTimes_over_expr(EZParser.Times_over_exprContext ctx) { 
        AST ast;
        AST left = visit(ctx.expr(0));
        AST right = visit(ctx.expr(1));

        if(ctx.op.getType() == EZParser.OVER) {
            Type type =  this.checkResultOperationType(left.type, left.type, ctx.getStart().getLine(),"/"); 
            ast = new AST(NodeKind.OVER_NODE,0, type);
            if(!makeAstOperation("/",ast, left,right, type)){
                System.out.println("Error : (" + ctx.getStart().getLine() + ") Não é esperado uma coversão em ambos os lados da expressão");
                System.exit(6);
            }

        } else if(ctx.op.getType() == EZParser.TIMES) {
            Type type = this.checkResultOperationType(left.type, right.type, ctx.getStart().getLine(),"*"); 
            ast = new AST(NodeKind.TIMES_NODE,0, type);
            if(!makeAstOperation("*", ast, left,right,type)){
                System.out.println("Error : (" + ctx.getStart().getLine() + ") Não é esperado uma coversão em ambos os lados da expressão");
                System.exit(6);
            }
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        }
        return ast;
    }

	@Override 
    public AST visitTrue(EZParser.TrueContext ctx) { 
        AST ast = new AST(NodeKind.BOOL_VAL_NODE, 1, Type.BOOL_TYPE);
        return ast; 
    }

	@Override 
    public AST visitFalse(EZParser.FalseContext ctx) { 
        AST ast = new AST(NodeKind.BOOL_VAL_NODE, 0, Type.BOOL_TYPE);
        return ast;  
    }

	@Override 
    public AST visitPlus_minus_expr(EZParser.Plus_minus_exprContext ctx) { 
        AST ast ;
        AST left = visit(ctx.expr(0));
        AST right = visit(ctx.expr(1));
        
        if(ctx.op.getType() == EZParser.PLUS) {
            Type type = this.checkResultOperationType(left.type, right.type, ctx.getStart().getLine(), "+"); 

            ast = new AST(NodeKind.PLUS_NODE, 0, type);

            
            if(!makeAstOperation("+",ast, left, right, type)){
                System.out.println("Error : (" + ctx.getStart().getLine() + ") Não é esperado uma coversão em ambos os lados da expressão");
                System.exit(6);
            }
            
            
        } else if(ctx.op.getType() == EZParser.MINUS) {
            Type type = this.checkResultOperationType(left.type, right.type, ctx.getStart().getLine(), "-"); 
            
            ast = new AST(NodeKind.MINUS_NODE, 0, type);

             if(!makeAstOperation("-", ast, left,right,type)){
                System.out.println("Error : (" + ctx.getStart().getLine() + ") Não é esperado uma coversão em ambos os lados da expressão");
                System.exit(6);
            }
            
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        } 
        return ast; 
    }

    private Type checkResultOperationType(Type type1, Type type2, int line, String op) {
        Type result = getReturnTypeOp(type1,type2,op);

        if(result == null){
            System.out.println("SEMANTIC ERROR (" + line + "): incompatible types for operator '" + op + "', LHS is '" + type1 + "' and RHS is '" + type2 + "'." );
            System.exit(7);
        }

        return result;
    }

	@Override 
    public AST visitEq_lt_epr(EZParser.Eq_lt_eprContext ctx) { 
        AST ast;
        AST left = visit(ctx.expr(0));
        AST right = visit(ctx.expr(1));

        if(ctx.op.getType() == EZParser.EQ) {
            checkResultComparisonType(left.type, right.type, ctx.getStart().getLine(), "=");
        } else if(ctx.op.getType() == EZParser.LT) {
            checkResultComparisonType(left.type, right.type, ctx.getStart().getLine(),"<"); 
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        }

        if(left.type != right.type)
        {
            if(ctx.op.getType() == EZParser.EQ)
            {
                ast = new AST(NodeKind.EQ_NODE,0,Type.REAL_TYPE);
            }
            else{
                ast = new AST(NodeKind.LT_NODE,0,Type.REAL_TYPE);
            }
            
            if(left.type == Type.INT_TYPE && right.type == Type.REAL_TYPE)
            {
                ast.addChild(insertConvertion(left, Type.REAL_TYPE, NodeKind.I2R_NODE));
                ast.addChild(right);
            }else if(right.type == Type.INT_TYPE && left.type == Type.REAL_TYPE){
                ast.addChild(left);
                ast.addChild(insertConvertion(right, Type.REAL_TYPE, NodeKind.I2R_NODE));
            }

        }else{
            ast = new AST(NodeKind.EQ_NODE,0,left.type);
            ast.addChild(left);
            ast.addChild(right);
        }
        return ast;        
    }

    private AST insertConvertion(AST sub, Type conv, NodeKind tipo ){
        AST wideNode = new AST(tipo, 0, conv);
        wideNode.addChild(sub);
        return wideNode;
    }

    private Boolean checkResultComparisonType(Type type1, Type type2, int line, String op) {
        Boolean result = this.getResultComparisonType(type1, type2);
        if(!result) {
            System.out.println("SEMANTIC ERROR (" + line + "): incompatible types for operator '" + op + "', LHS is '" + type1 + "' and RHS is '" + type2 + "'.");
            System.exit(7);
        }
        return result;
    }

    private Boolean getResultComparisonType(Type type1, Type type2) {
        if(type1 == Type.INT_TYPE && type2 == Type.INT_TYPE) {
            return true;
        }

        if(type1 == Type.REAL_TYPE && type2 == Type.REAL_TYPE) {
            return true;
        }

        if(type1 == Type.INT_TYPE && type2 == Type.REAL_TYPE) {
            return true;
        }

        if(type1 == Type.REAL_TYPE && type2 == Type.INT_TYPE) {
            return true;
        }

        if(type1 == Type.STR_TYPE && type2 == Type.STR_TYPE) {
            return true;
        }

        return false;
    }

    @Override 
    public AST visitReal_val(EZParser.Real_valContext ctx) { 
        float value = Float.parseFloat(ctx.REAL_VAL().getText());
        AST ast = new AST(NodeKind.REAL_VAL_NODE, value, Type.REAL_TYPE);
        return ast;
    }
	
	@Override 
    public AST visitPar_expr(EZParser.Par_exprContext ctx) { 
        AST ast = visit(ctx.expr());
        return ast;
    }
	
	
	@Override 
    public AST visitInt_val(EZParser.Int_valContext ctx) { 
        int value = Integer.parseInt(ctx.INT_VAL().getText());
        AST ast = new AST(NodeKind.INT_VAL_NODE, value, Type.INT_TYPE);
        return ast;
    }

    private Type[][] getSemanticTableByOp(String op) {
        switch(op) {        
            case "+":
                Type[][] matrix1 = {
                    {Type.INT_TYPE, Type.REAL_TYPE, Type.INT_TYPE, Type.STR_TYPE},
                    {Type.REAL_TYPE, Type.REAL_TYPE, Type.REAL_TYPE, Type.STR_TYPE},
                    {Type.INT_TYPE, Type.REAL_TYPE, Type.BOOL_TYPE, Type.STR_TYPE},
                    {Type.STR_TYPE, Type.STR_TYPE, Type.STR_TYPE, Type.STR_TYPE}
                };
                return matrix1;
            case "-":
            case "*":
            case "/":
                Type[][] matrix2 = {
                    {Type.INT_TYPE, Type.REAL_TYPE, null, null},
                    {Type.REAL_TYPE, Type.REAL_TYPE, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                };
                return matrix2;
            default:
                return null;
        }
    }

    private NodeKind getNodeKindConversion(String op, Type type1, Type type2) {
        NodeKind[][] matrix  = getConversion(op);
        return matrix[type1.toInteger()][type2.toInteger()];
    }

    private NodeKind[][] getConversion(String op) {
        switch(op) {        
            case "+":
                NodeKind[][] matrix1 = {
                    {null, NodeKind.I2R_NODE, null, NodeKind.I2S_NODE},
                    {null,null, null,NodeKind.R2S_NODE},
                    {NodeKind.B2I_NODE, NodeKind.B2R_NODE, null, NodeKind.B2S_NODE},
                    {null,null,null, null} 
                };
                return matrix1;
            case "-":
            case "*":
            case "/":
                NodeKind[][] matrix2 = {
                    {null, NodeKind.I2R_NODE, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                };
                return matrix2;
            default:
                return null;
        }
    }

    private Type getReturnTypeOp(Type type1, Type type2, String op) {
        Type[][] matrix = this.getSemanticTableByOp(op);
        return matrix[type1.toInteger()][type2.toInteger()];
    }

    @Override 
    public AST visitSample_if(EZParser.Sample_ifContext ctx) { 
        AST ast = new AST(NodeKind.IF_NODE,0,Type.NO_TYPE);
        AST astExpr = visit(ctx.expr());

        if(astExpr.type == Type.BOOL_TYPE) {
            ast.addChild(astExpr);
            AST block = new AST(NodeKind.BLOCK_NODE,0,Type.NO_TYPE);

            for(int i = 0; i < ctx.stmt().size(); i++) {
                AST child = visit(ctx.stmt(i));
                block.addChild(child);
            }

            ast.addChild(block);
        } else {
            System.out.println("SEMANTIC ERROR (" + ctx.getStart().getLine() + "): conditional expression in 'if' is '" + astExpr.type + "' instead of 'bool'.");
            System.exit(7);
        }
        return ast;  
    }
    
	@Override 
    public AST visitIf_else(EZParser.If_elseContext ctx) { 
        AST ast = new AST(NodeKind.IF_NODE,0,Type.NO_TYPE);
        AST astExpr = visit(ctx.expr());

        if(astExpr.type == Type.BOOL_TYPE) {
            ast.addChild(astExpr);
            AST block = new AST(NodeKind.BLOCK_NODE,0,Type.NO_TYPE);

            for(int i = 0; i < ctx.stmt().size(); i++) {
                AST child = visit(ctx.stmt(i));
                block.addChild(child);
            }

            ast.addChild(block);
        } else {
            System.out.println("SEMANTIC ERROR (" + ctx.getStart().getLine() + "): conditional expression in 'if' is '" + astExpr.type + "' instead of 'bool'.");
            System.exit(7);
        }
        return ast;  
    }

    @Override 
    public AST visitRepeatstmt(EZParser.RepeatstmtContext ctx) { 
        AST ast = new AST(NodeKind.REPEAT_NODE, 0, Type.NO_TYPE);

        AST astExpr = visit(ctx.expr());

        if(astExpr.type == Type.BOOL_TYPE) {
            AST block = new AST(NodeKind.BLOCK_NODE, 0, Type.NO_TYPE);
            
            for(int i = 0; i < ctx.stmt().size(); i++) {
                AST child = visit(ctx.stmt(i));
                block.addChild(child);
            }

            ast.addChild(block);
            ast.addChild(astExpr); // expr deve ser o filho a direita no repeat
        } else {
            System.out.println("SEMANTIC ERROR (" + ctx.expr().getStart().getLine() + "): conditional expression in 'repeat' is '" + astExpr.type + "' instead of 'bool'.");
            System.exit(7);
        }
        return ast; 
    }
}
