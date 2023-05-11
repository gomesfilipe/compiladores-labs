// import parser.EZParser;
import tables.StrTable;
import tables.VarTable;
import typing.Type;
// import parser.EZParserBaseVisitor;

import parser.EZParser;
import parser.EZParserBaseVisitor;

public class Visitor extends EZParserBaseVisitor<Type>{
    private StrTable strTable = new StrTable();
    private VarTable varTable = new VarTable();
    
    @Override
    public Type visitStr_val(EZParser.Str_valContext ctx) {
        strTable.add(ctx.STR_VAL().getText());
        return Type.INT_TYPE; // PERGUNTAR
    }

    public StrTable getStrTable() {
        return this.strTable;
    }

    public VarTable getVarTable() {
        return this.varTable;
    }

    @Override 
    public Type visitVardecl(EZParser.VardeclContext ctx) {
        
        Type type = visit(ctx.typespec());
        System.out.println(type);

        

        this.handleVarTableVardecl(ctx, type);
        return Type.INT_TYPE; // PERGUNTAR
    }

    private String handleVarTableVardecl(EZParser.VardeclContext ctx, Type type) {
        if(varTable.lookupVar(ctx.ID().getText()) != -1) { // Existe, disparar erro!
            System.out.println("Variável " + ctx.ID().getText() + "redeclarada.");
            System.exit(1);
            return "";
        } else {
            // varTable.addVar(ctx.ID().getText(), ctx.ID().getLine(), type);
            varTable.addVar(ctx.ID().getText(), ctx.getStart().getLine(), type);
            return "";
        }
    }

    @Override
    public Type visitBool(EZParser.BoolContext ctx)
    {
        System.out.println("Bool");
        // return ctx.BOOL().getText();
        return Type.BOOL_TYPE;
    }

    @Override
    public Type visitInt(EZParser.IntContext ctx)
    {
        System.out.println("Int");
        return Type.INT_TYPE;

    }

    @Override
    public Type visitReal(EZParser.RealContext ctx)
    {
        System.out.println("real");
        return Type.REAL_TYPE;
    }

    @Override
    public Type visitString(EZParser.StringContext ctx)
    {
        System.out.println("string");
        return Type.STR_TYPE;
    }
    
}
