// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Q01Parser}.
 */
public interface Q01Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Q01Parser#begin}.
	 * @param ctx the parse tree
	 */
	void enterBegin(Q01Parser.BeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link Q01Parser#begin}.
	 * @param ctx the parse tree
	 */
	void exitBegin(Q01Parser.BeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link Q01Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Q01Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Q01Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Q01Parser.ExprContext ctx);
}