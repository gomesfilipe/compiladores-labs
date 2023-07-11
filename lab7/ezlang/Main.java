import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.EZLexer;
import parser.EZParser;
import ast.AST;
import code.CodeGen;
import code.Instruction;
import code.Interpreter;


public class Main {
    public static void main(String[] args) throws IOException {
		// Cria um CharStream que lê os caracteres de stdin.
		// CharStream input = CharStreams.fromStream(System.in);
		CharStream input = CharStreams.fromFileName(args[0]);
		// Cria um lexer que consome a entrada do CharStream.
		EZLexer lexer = new EZLexer(input);

		// Cria um buffer de tokens vindos do lexer.
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Cria um parser que consome os tokens do buffer.
		EZParser parser = new EZParser(tokens);

		// Começa o processo de parsing na regra 'line'.
		ParseTree tree = parser.program();

		if (parser.getNumberOfSyntaxErrors() != 0) {
			// Houve algum erro sintático. Termina a compilação aqui.
			return;
		}

		// Cria a calculadora e visita a ParseTree para computar.
		Visitor visitor = new Visitor();
		AST ast = visitor.visit(tree);

		// System.out.println("PARSE SUCCESSFUL!");
		// System.out.print("\n\n");
		// AST.printDot(ast, visitor.getVarTable());
		// System.out.println(visitor.getStrTable().toString());
		// System.out.print("\n");
		// System.out.println(visitor.getVarTable().toString());
		// System.out.print("\n");

		// Interpreter interpreter = new Interpreter(visitor.getStrTable(), visitor.getVarTable());
		// interpreter.execute(ast);


		// Executa o gerador de código.
		CodeGen codeGen = new CodeGen(visitor.getStrTable(), visitor.getVarTable());
		codeGen.execute(ast);
		
	}
}
