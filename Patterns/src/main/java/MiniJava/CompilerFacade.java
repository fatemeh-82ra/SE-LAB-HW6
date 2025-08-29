package MiniJava;

import MiniJava.errorHandler.ErrorHandler;
import MiniJava.parser.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CompilerFacade {
    /**
     * This method provides a simple interface to start the entire compilation process.
     * It hides the low-level details of parser initialization and file handling.
     * @param sourceFilePath The path to the MiniJava source code file.
     */
    public void compile(String sourceFilePath) {
        Parser parser = new Parser();
        try {
            parser.startParse(new Scanner(new File(sourceFilePath)));
        } catch (FileNotFoundException e) {
            ErrorHandler.printError(e.getMessage());
        }
    }
}