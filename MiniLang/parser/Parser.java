package parser;

import ast.*;
import antlr.*;
import java.util.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Parser {
    public static Program parse(String input) throws Exception {
        CharStream cs = CharStreams.fromString(input);
        MiniLangLexer lexer = new MiniLangLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniLangParser p = new MiniLangParser(tokens);
        ParseTree tree = p.program();

        ASTBuilderVisitor v = new ASTBuilderVisitor();
        return (Program) v.visit(tree);
    }

    // inner visitor
    static class ASTBuilderVisitor extends MiniLangBaseVisitor<ASTNode> {
        @Override
        public Program visitProgram(MiniLangParser.ProgramContext ctx) {
            List<Stmt> stmts = new ArrayList<>();
            for (MiniLangParser.StatementContext sctx : ctx.statement()) {
                Stmt s = (Stmt) visit(sctx);
                stmts.add(s);
            }
            return new Program(stmts);
        }

        @Override
        public ASTNode visitAssignment(MiniLangParser.AssignmentContext ctx) {
            String name = ctx.IDENT().getText();
            Expr expr = (Expr) visit(ctx.expr());
            return new AssignStmt(name, expr);
        }

        @Override
        public ASTNode visitPrintStmt(MiniLangParser.PrintStmtContext ctx) {
            Expr e = (Expr) visit(ctx.expr());
            return new PrintStmt(e);
        }

        @Override
        public ASTNode visitInt(MiniLangParser.IntContext ctx) {
            return new IntLiteral(Integer.parseInt(ctx.INT().getText()));
        }

        @Override
        public ASTNode visitVar(MiniLangParser.VarContext ctx) {
            return new VarExpr(ctx.IDENT().getText());
        }

        @Override
        public ASTNode visitParens(MiniLangParser.ParensContext ctx) {
            return (Expr) visit(ctx.expr());
        }

        @Override
        public ASTNode visitMulDiv(MiniLangParser.MulDivContext ctx) {
            Expr left = (Expr) visit(ctx.expr(0));
            Expr right = (Expr) visit(ctx.expr(1));
            return new BinOp(ctx.op.getText(), left, right);
        }

        @Override
        public ASTNode visitAddSub(MiniLangParser.AddSubContext ctx) {
            Expr left = (Expr) visit(ctx.expr(0));
            Expr right = (Expr) visit(ctx.expr(1));
            return new BinOp(ctx.op.getText(), left, right);
        }
    }
}
