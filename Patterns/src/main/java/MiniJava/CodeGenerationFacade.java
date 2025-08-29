package MiniJava;

import MiniJava.codeGenerator.CodeGenerator;
import MiniJava.errorHandler.ErrorHandler;
import MiniJava.scanner.token.Token;

public class CodeGenerationFacade {
    private final CodeGenerator codeGenerator;

    public CodeGenerationFacade() {
        // The facade creates and manages the complex CodeGenerator subsystem.
        this.codeGenerator = new CodeGenerator();
    }

    /**
     * A simple method for the parser to call, hiding the 'semanticFunction' detail.
     */
    public void executeSemanticAction(int actionNumber, Token lookAhead) {
        codeGenerator.semanticFunction(actionNumber, lookAhead);
    }

    /**
     * A simple method to print the final result.
     */
    public void printFinalCode() {
        if (!ErrorHandler.hasError) {
            codeGenerator.printMemory();
        }
    }
}