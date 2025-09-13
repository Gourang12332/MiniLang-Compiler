import parser.Parser;
import ast.Program;
import semantic.SemanticAnalyzer;
import codegen.CodeGenerator;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("Usage: java Main <source.mini>");
            System.exit(1);
        }
        String src = new String(Files.readAllBytes(Paths.get(args[0])));
        Program prog = Parser.parse(src);
        SemanticAnalyzer.analyze(prog);
        new CodeGenerator().run(prog, "program.ll");

        
        ProcessBuilder copyToWSL = new ProcessBuilder(
            "wsl", "bash", "-c",
            "cp /mnt/d/MiniLang/program.ll /tmp/program.ll"
        );
        copyToWSL.inheritIO().start().waitFor();

       
        ProcessBuilder pb1 = new ProcessBuilder(
            "wsl", "llc", "/tmp/program.ll", "-filetype=obj", "-o", "/tmp/program.o"
        );
        pb1.inheritIO().start().waitFor();

        ProcessBuilder pb2 = new ProcessBuilder(
            "wsl", "clang", "-no-pie","/tmp/program.o", "-o", "/tmp/program.exe"
        );
        pb2.inheritIO().start().waitFor();

        System.out.println("Compilation Finished inside WSL. Run with: wsl /tmp/program.exe");



         
    }
}
