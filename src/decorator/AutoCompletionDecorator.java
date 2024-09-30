package decorator;

// Decorator Pattern - Adding Auto-Completion to CodeEditor
public class AutoCompletionDecorator extends CodeEditor {
    private CodeEditor editor;

    public AutoCompletionDecorator(CodeEditor editor) {
        this.editor = editor;
    }

    @Override
    public void display() {
        editor.display();
        System.out.println("Auto-completion feature enabled.");
    }
}
