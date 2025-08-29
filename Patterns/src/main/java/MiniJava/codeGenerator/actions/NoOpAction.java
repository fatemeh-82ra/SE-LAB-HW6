package MiniJava.codeGenerator.actions;

import MiniJava.codeGenerator.CodeGenerator;
import MiniJava.codeGenerator.SemanticAction;
import MiniJava.scanner.token.Token;

// For case 0
public class NoOpAction implements SemanticAction {
    @Override
    public void execute(CodeGenerator cg, Token next) {
        // Does nothing, as per the original case 0 logic.
    }
}