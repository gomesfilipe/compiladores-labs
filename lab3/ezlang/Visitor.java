// import parser.EZParser;
import tables.StrTable;
// import parser.EZParserBaseVisitor;

import parser.EZParser;
import parser.EZParserBaseVisitor;

public class Visitor extends EZParserBaseVisitor<Void> {
    private StrTable strTable = new StrTable();
    
    @Override
    public Void visitStr_val(EZParser.Str_valContext ctx) {
        strTable.add(ctx.STR_VAL().getText());
        return null;
    }

    public StrTable getStrTable() {
        return this.strTable;
    }
}
