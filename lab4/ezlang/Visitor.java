// import parser.EZParser;
import tables.StrTable;
import tables.VarTable;
import typing.Type;

import parser.EZParser;
import parser.EZParserBaseVisitor;

public class Visitor extends EZParserBaseVisitor<Type>{
    private StrTable strTable = new StrTable();
    private VarTable varTable = new VarTable();
    private Type currentType;

    @Override
    public Type visitStr_val(EZParser.Str_valContext ctx) {
        strTable.add(ctx.STR_VAL().getText());
        return null;
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
    public Type visitAssignstmt(EZParser.AssignstmtContext ctx) {
        this.handleIdInMain(ctx.ID().getText());
        Type typeID = varTable.getTypeByName(ctx.ID().getText());
        Type typeExpr = visit(ctx.expr());
        
        if(!this.checkResultAtributionType(typeID, typeExpr)) {
            System.out.println("SEMANTIC ERROR (" + ctx.getLine() + "): incompatible types for operator '" + ctx.ASSIGN.getText() + "', LHS is " + typeID + " and RHS is " + typeExpr + "." );
            System.exit(7);
        }

        return null; 
    }

    @Override 
    public Type visitReadstmt(EZParser.ReadstmtContext ctx) {
        this.handleIdInMain(ctx.ID().getText());
        return null; 
    }

    @Override 
    public Type visitId(EZParser.IdContext ctx) { 
        this.handleIdInMain(ctx.ID().getText());
        return null; 
    }

    private Type handleIdInMain(String id) {
        if(varTable.lookupVar(id) == -1) { // Não existe, disparar erro!
            System.out.println("SEMANTIC ERROR (9): variable '" + id + "' was not declared.");
            System.exit(1);
        }

        return null;
    }

    private Boolean checkResultAtributionType(Type type1, Type type2) {
        if(type1 == type2) {
            return true;
        } 

        if(type1 == Type.REAL_TYPE && type2.INT_TYPE) {
            return true;
        }

        return false;
    }

    private Boolean checkResultComparisonType(Type type1, Type type2) {
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
}

// 