package ast;

public class PrintStmt extends Stmt {
    public final Expr expr;
    public PrintStmt(Expr expr) { this.expr = expr; }
}
