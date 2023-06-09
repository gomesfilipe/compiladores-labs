// Generated from java-escape by ANTLR 4.11.1

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Exemplo02Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Exemplo02Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Exemplo02Parser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(Exemplo02Parser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link Exemplo02Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Exemplo02Parser.ExprContext ctx);
}