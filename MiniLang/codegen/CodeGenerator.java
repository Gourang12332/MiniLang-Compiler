package codegen;

import ast.*;
import java.io.*;
import java.util.*;

public class CodeGenerator {
    private PrintWriter out;
    private int tempCount = 0;
    private Map<String, String> vars = new HashMap<>();

    public void run(Program prog, String filename) throws Exception {
        out = new PrintWriter(new FileWriter(filename));
        emitHeader();

        for (Stmt s : prog.statements) {
            if (s instanceof AssignStmt) {
                genAssign((AssignStmt) s);
            } else if (s instanceof PrintStmt) {
                genPrint((PrintStmt) s);
            }
        }

        emitFooter();
        out.close();
    }

    private void emitHeader() {
        out.println("; ModuleID = 'mini'");
        out.println("declare i32 @printf(i8*, ...)");
        out.println("@fmt = private constant [4 x i8] c\"%d\\0A\\00\"");
        out.println("define i32 @main() {");
    }

    private void emitFooter() {
        out.println("  ret i32 0");
        out.println("}");
    }

    private void genAssign(AssignStmt a) {
        String val = genExpr(a.expr);
        vars.put(a.name, val);
    }

    private void genPrint(PrintStmt p) {
        String val = genExpr(p.expr);
        out.println("  call i32 (i8*, ...) @printf(i8* getelementptr " +
            "([4 x i8], [4 x i8]* @fmt, i32 0, i32 0), i32 " + val + ")");
    }

    private String genExpr(Expr e) {
        if (e instanceof IntLiteral) {
            return Integer.toString(((IntLiteral) e).value);
        }
        if (e instanceof VarExpr) {
            return vars.get(((VarExpr) e).name);
        }
        if (e instanceof BinOp) {
            BinOp b = (BinOp) e;
            String l = genExpr(b.left);
            String r = genExpr(b.right);
            String t = "%t" + (tempCount++);
            switch (b.op) {
                case "+": out.println("  " + t + " = add i32 " + l + ", " + r); break;
                case "-": out.println("  " + t + " = sub i32 " + l + ", " + r); break;
                case "*": out.println("  " + t + " = mul i32 " + l + ", " + r); break;
                case "/": out.println("  " + t + " = sdiv i32 " + l + ", " + r); break;
            }
            return t;
        }
        throw new RuntimeException("Unknown expr");
    }
}
