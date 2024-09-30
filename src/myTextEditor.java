import observer.*;
import command.*;
import strategy.*;
import decorator.*;
import memento.*;
import singleton.*;

// IDE Simulation
public class myTextEditor {
    public static void main(String[] args) {
        // Observer Pattern - FileManager and FileEditor
        FileManager fileManager = new FileManager();
        FileEditor fileEditor = new FileEditor("Initial content of test.java");
        fileManager.addListener(fileEditor);
        fileManager.openFile("test.java", "Initial content of test.java");
        fileManager.editFile("test.java", "Modified content of test.java");

        // Command Pattern - Undo Command
        UndoCommand undoCommand = new UndoCommand(fileManager.getFileEditor("test.java"));
        undoCommand.execute();

        // Strategy Pattern - Syntax Highlighter
        SyntaxHighlighter pythonHighlighter = SyntaxHighlighterFactory.getHighlighter("python");
        pythonHighlighter.highlight("def hello_world():");

        SyntaxHighlighter javaHighlighter = SyntaxHighlighterFactory.getHighlighter("java");
        javaHighlighter.highlight("public static void main(String[] args) {}");

        // Decorator Pattern - Auto-Completion
        CodeEditor basicEditor = new BasicEditor();
        CodeEditor editorWithAutoComplete = new AutoCompletionDecorator(basicEditor);
        editorWithAutoComplete.display();

        // Memento Pattern - Saving and Restoring Editor State
        EditorHistory editorHistory = new EditorHistory();
        editorHistory.saveState(new EditorState(fileEditor.getContent()));

        // Modify file and save new state
        fileManager.editFile("test.java", "Second modification.");
        editorHistory.saveState(new EditorState(fileEditor.getContent()));

        // Undo to restore previous state
        EditorState previousState = editorHistory.undo();
        if (previousState != null) {
            fileManager.getFileEditor("test.java").editContent(previousState.getContent());
            System.out.println("Restored content: " + fileManager.getFileEditor("test.java").getContent());
        }

        // Singleton Pattern - Apply Theme
        ThemeManager themeManager = ThemeManager.getInstance();
        themeManager.applyTheme("Dark Mode");

        // Final output
        System.out.println("Final content of test.java: " + fileManager.getFileEditor("test.java").getContent());
    }
}
