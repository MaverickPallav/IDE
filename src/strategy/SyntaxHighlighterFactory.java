package strategy;

// Factory Pattern - Syntax Highlighter Factory
public class SyntaxHighlighterFactory {
    public static SyntaxHighlighter getHighlighter(String language) {
        switch (language.toLowerCase()) {
            case "python":
                return new PythonHighlighter();
            case "java":
                return new JavaHighlighter();
            default:
                throw new IllegalArgumentException("Unsupported language");
        }
    }
}
