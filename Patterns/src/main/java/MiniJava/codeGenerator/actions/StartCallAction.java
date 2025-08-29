package MiniJava.codeGenerator.actions;

import MiniJava.codeGenerator.CodeGenerator;
import MiniJava.codeGenerator.SemanticAction;
import MiniJava.scanner.token.Token;

public class StartCallAction implements SemanticAction {
    @Override
    public void execute(CodeGenerator cg, Token next) {
        cg.startCall();
    }
}