package strategy;

// Strategy Pattern - Java Highlighter
public class JavaHighlighter implements SyntaxHighlighter {
    @Override
    public void highlight(String code) {
        System.out.println("Syntax Highlighting for Java code: " + code);
    }
}
