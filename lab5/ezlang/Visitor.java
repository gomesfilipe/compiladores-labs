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
    public Type visitStr_val(EZParser.Str_valContext ctx) {
        strTable.add(ctx.STR_VAL().getText());
        return Type.STR_TYPE;
    }

    public StrTable getStrTable() {
        return this.strTable;
    }

    public VarTable getVarTable() {
        return this.varTable;
    }

    @Override 
    public Type visitVardecl(EZParser.VardeclContext ctx) {
        this.handleVarTableVardecl(ctx);
        return null;
    }

    private Type handleVarTableVardecl(EZParser.VardeclContext ctx) {
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
    public Type visitBool(EZParser.BoolContext ctx) {
        this.currentType = Type.BOOL_TYPE;
        return null;
    }

    @Override
    public Type visitInt(EZParser.IntContext ctx) {
        this.currentType = Type.INT_TYPE;
        return null;

    }

    @Override
    public Type visitReal(EZParser.RealContext ctx) {
        this.currentType = Type.REAL_TYPE;
        return null;
    }

    @Override
    public Type visitString(EZParser.StringContext ctx) {
        this.currentType = Type.STR_TYPE;
        return null;
    }

    @Override 
    public AST visitAssignstmt(EZParser.AssignstmtContext ctx) {
        this.handleIdInMain(ctx.ID().getText());
        Type typeID = varTable.getTypeByName(ctx.ID().getText());
        AST astExpr = visit(ctx.expr());
        
        checkResultAtributionType(typeID, typeExpr, ctx.getStart().getLine(), ":=");
        
        AST ast = new AST(ASSIGN_NODE, 0, NO_TYPE);
        AST left = new AST(VAR_USE_NODE, 0, typeID);
        ast.addChild(left);
        AST wideNode;
        
        // Se precisa fazer cast
        if(typeExpr == TYPE.INT_TYPE && typeID == TYPE.REAL_TYPE) {
            wideNode = new AST(I2R_NODE, 0, TYPE.REAL_TYPE);
            wideNode.addChild(astExpr);
            ast.addChild(wideNode);
        } else {
            ast.add(astExpr);
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
    public Type visitReadstmt(EZParser.ReadstmtContext ctx) {
        this.handleIdInMain(ctx.ID().getText());
        return null; 
    }

    @Override 
    public Type visitId(EZParser.IdContext ctx) { 
        return this.handleIdInMain(ctx.ID().getText());
    }

    private Type handleIdInMain(String id) {
        if(varTable.lookupVar(id) == -1) { // Não existe, disparar erro!
            System.out.println("SEMANTIC ERROR (9): variable '" + id + "' was not declared.");
            System.exit(1);
        }

        return this.varTable.getTypeByName(id);
    }

    @Override 
    public Type visitTimes_over_expr(EZParser.Times_over_exprContext ctx) { 
        Type type1 = visit(ctx.expr(0));
        Type type2 = visit(ctx.expr(1));
        
        if(ctx.op.getType() == EZParser.OVER) {
            return this.checkResultOperationType(type1, type2, ctx.getStart().getLine(),"/"); 

        } else if(ctx.op.getType() == EZParser.TIMES) {
            return this.checkResultOperationType(type1, type2, ctx.getStart().getLine(),"*"); 
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        }
    }

	@Override 
    public Type visitTrue(EZParser.TrueContext ctx) { 
        return Type.BOOL_TYPE; 
    }

	@Override 
    public Type visitFalse(EZParser.FalseContext ctx) { 
        return Type.BOOL_TYPE;  
    }

	@Override 
    public Type visitPlus_minus_expr(EZParser.Plus_minus_exprContext ctx) { 
        Type type1 = visit(ctx.expr(0));
        Type type2 = visit(ctx.expr(1));
        
        if(ctx.op.getType() == EZParser.PLUS) {
            return this.checkResultOperationType(type1, type2, ctx.getStart().getLine(),"+"); 

        } else if(ctx.op.getType() == EZParser.MINUS) {
            return this.checkResultOperationType(type1, type2, ctx.getStart().getLine(),"-"); 
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        }
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
    public Type visitEq_lt_epr(EZParser.Eq_lt_eprContext ctx) { 
        Type type1 = visit(ctx.expr(0));
        Type type2 = visit(ctx.expr(1));

        if(ctx.op.getType() == EZParser.EQ) {
            checkResultComparisonType(type1,type2,ctx.getStart().getLine(),"=");
            return Type.BOOL_TYPE;

        } else if(ctx.op.getType() == EZParser.LT) {
            checkResultComparisonType(type1,type2,ctx.getStart().getLine(),"<"); 
            return Type.BOOL_TYPE;
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        }
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
    public Type visitReal_val(EZParser.Real_valContext ctx) { 
        return Type.REAL_TYPE; 
    }
	
	@Override 
    public Type visitPar_expr(EZParser.Par_exprContext ctx) { 
        return visit(ctx.expr()); 
    }
	
	
	@Override 
    public Type visitInt_val(EZParser.Int_valContext ctx) { 
        return Type.INT_TYPE;
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

    private Type getReturnTypeOp(Type type1, Type type2, String op) {
        Type[][] matrix = this.getSemanticTableByOp(op);
        return matrix[type1.toInteger()][type2.toInteger()];
    }

    @Override 
    public Type visitSample_if(EZParser.Sample_ifContext ctx) { 
        Type typeExpr = visit(ctx.expr());

        if(typeExpr == Type.BOOL_TYPE) {
            for(int i = 0; i < ctx.stmt().size(); i++) {
                visit(ctx.stmt(i));
            }
        } else {
            System.out.println("SEMANTIC ERROR (" + ctx.getStart().getLine() + "): conditional expression in 'if' is '" + typeExpr + "' instead of 'bool'.");
            System.exit(7);
        }
        return null;  
    }
	
	@Override 
    public Type visitIf_else(EZParser.If_elseContext ctx) { 
        Type typeExpr = visit(ctx.expr());

        if(typeExpr == Type.BOOL_TYPE) {
            for(int i = 0; i < ctx.stmt().size(); i++) {
                visit(ctx.stmt(i));
            }
        } else {
            System.out.println("SEMANTIC ERROR (" + ctx.getStart().getLine() + "): conditional expression in 'if' is '" + typeExpr + "' instead of 'bool'.");
            System.exit(7);
        }
        return null;  
    }

    @Override 
    public Type visitRepeatstmt(EZParser.RepeatstmtContext ctx) { 
        Type typeExpr = visit(ctx.expr());

        if(typeExpr == Type.BOOL_TYPE) {
            for(int i = 0; i < ctx.stmt().size(); i++) {
                visit(ctx.stmt(i));
            }
        } else {
            System.out.println("SEMANTIC ERROR (" + ctx.expr().getStart().getLine() + "): conditional expression in 'repeat' is '" + typeExpr + "' instead of 'bool'.");
            System.exit(7);
        }
        return null; 
    }
}
