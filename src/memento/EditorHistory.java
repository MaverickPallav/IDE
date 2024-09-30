package memento;

import java.util.Stack;

// Memento Pattern - Editor History to Save States
public class EditorHistory {
    private Stack<EditorState> history = new Stack<>();

    public synchronized void saveState(EditorState state) { // Synchronizing this method
        history.push(state);
    }

    public synchronized EditorState undo() { // Synchronizing this method
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
