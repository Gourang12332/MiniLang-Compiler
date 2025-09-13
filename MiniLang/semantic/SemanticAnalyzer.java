package semantic;

import ast.*;
import java.util.*;

public class SemanticAnalyzer {
    public static void analyze(Program prog) {
        Set<String> defined = new HashSet<>();
        for (Stmt s : prog.statements) {
            if (s instanceof AssignStmt) {
                AssignStmt a = (AssignStmt) s;
                checkExpr(a.expr, defined);
                defined.add(a.name);
            } else if (s instanceof PrintStmt) {
                PrintStmt p = (PrintStmt) s;
                checkExpr(p.expr, defined);
            }
        }
    }

    private static void checkExpr(Expr e, Set<String> defined) {
        if (e instanceof IntLiteral) return;
        if (e instanceof VarExpr) {
            String name = ((VarExpr) e).name;
            if (!defined.contains(name)) {
                throw new RuntimeException("Semantic error: variable '" + name + "' used before assignment");
            }
        } else if (e instanceof BinOp) {
            BinOp b = (BinOp) e;
            checkExpr(b.left, defined);
            checkExpr(b.right, defined);
        }
    }
}
