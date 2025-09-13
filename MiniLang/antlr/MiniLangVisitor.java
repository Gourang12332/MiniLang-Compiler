package antlr;
// Generated from ./grammar/MiniLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniLangParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(MiniLangParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(MiniLangParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(MiniLangParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(MiniLangParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(MiniLangParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(MiniLangParser.IntContext ctx);
}