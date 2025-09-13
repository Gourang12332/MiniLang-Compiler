package antlr;
// Generated from ./grammar/MiniLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLangParser}.
 */
public interface MiniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(MiniLangParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(MiniLangParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(MiniLangParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(MiniLangParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(MiniLangParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(MiniLangParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(MiniLangParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(MiniLangParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(MiniLangParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(MiniLangParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(MiniLangParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(MiniLangParser.IntContext ctx);
}