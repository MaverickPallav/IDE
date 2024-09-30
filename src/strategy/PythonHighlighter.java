package strategy;

// Strategy Pattern - Python Highlighter
public class PythonHighlighter implements SyntaxHighlighter {
    @Override
    public void highlight(String code) {
        System.out.println("Syntax Highlighting for Python code: " + code);
    }
}
