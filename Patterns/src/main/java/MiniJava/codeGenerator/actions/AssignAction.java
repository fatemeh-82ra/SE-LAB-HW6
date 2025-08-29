// In file .../actions/AssignAction.java
package MiniJava.codeGenerator.actions;

import MiniJava.codeGenerator.CodeGenerator;
import MiniJava.codeGenerator.SemanticAction;
import MiniJava.scanner.token.Token;

public class AssignAction implements SemanticAction {
    @Override
    public void execute(CodeGenerator cg, Token next) {
        cg.assign();
    }
}