package ast;

public class BinOp extends Expr {
    public final String op;
    public final Expr left, right;
    public BinOp(String op, Expr l, Expr r) { this.op = op; left = l; right = r; }
}
