// import parser.EZParser;
import tables.StrTable;
import tables.VarTable;
import typing.Type;
// import parser.EZParserBaseVisitor;

import parser.EZParser;
import parser.EZParserBaseVisitor;

public class Visitor extends EZParserBaseVisitor<Void>{
    private StrTable strTable = new StrTable();
    private VarTable varTable = new VarTable();
    private Type currentType;

    @Override
    public Void visitStr_val(EZParser.Str_valContext ctx) {
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
    public Void visitVardecl(EZParser.VardeclContext ctx) {
        this.handleVarTableVardecl(ctx);
        return null;
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
    public Void visitBool(EZParser.BoolContext ctx) {
        this.currentType = Type.BOOL_TYPE;
        return null;
    }

    @Override
    public Void visitInt(EZParser.IntContext ctx) {
        this.currentType = Type.INT_TYPE;
        return null;

    }

    @Override
    public Void visitReal(EZParser.RealContext ctx) {
        this.currentType = Type.REAL_TYPE;
        return null;
    }

    @Override
    public Void visitString(EZParser.StringContext ctx) {
        this.currentType = Type.STR_TYPE;
        return null;
    }
    
    @Override 
    public Void visitAssignstmt(EZParser.AssignstmtContext ctx) {
        visit(ctx.expr());
        this.handleIdInMain(ctx.ID().getText());
        return null; 
    }

    @Override 
    public Void visitReadstmt(EZParser.ReadstmtContext ctx) {
        this.handleIdInMain(ctx.ID().getText());
        return null; 
    }

    @Override 
    public Void visitId(EZParser.IdContext ctx) { 
        this.handleIdInMain(ctx.ID().getText());
        return null; 
    }

    private Void handleIdInMain(String id) {
        if(varTable.lookupVar(id) == -1) { // Não existe, disparar erro!
            System.out.println("SEMANTIC ERROR (9): variable '" + id + "' was not declared.");
            System.exit(1);
        }

        return null;
    }
}
