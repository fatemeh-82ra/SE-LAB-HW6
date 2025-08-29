package MiniJava.codeGenerator;

import MiniJava.scanner.token.Token;

public interface SemanticAction {
    void execute(CodeGenerator cg, Token next);
}