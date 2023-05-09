// Generated from java-escape by ANTLR 4.11.1

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EZParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EZParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EZParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(EZParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#varssect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarssect(EZParser.VarssectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(EZParser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#typespec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypespec(EZParser.TypespecContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#stmtsect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtsect(EZParser.StmtsectContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(EZParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#assignstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstmt(EZParser.AssignstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(EZParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#readstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadstmt(EZParser.ReadstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#repeatstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatstmt(EZParser.RepeatstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EZParser#writestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritestmt(EZParser.WritestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code real_val}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_val(EZParser.Real_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code par_expr}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar_expr(EZParser.Par_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code str_val}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr_val(EZParser.Str_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int_val}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_val(EZParser.Int_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code times_over_expr}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimes_over_expr(EZParser.Times_over_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code true}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(EZParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code false}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(EZParser.FalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(EZParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plus_minus_expr}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus_minus_expr(EZParser.Plus_minus_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eq_lt_epr}
	 * labeled alternative in {@link EZParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq_lt_epr(EZParser.Eq_lt_eprContext ctx);
}