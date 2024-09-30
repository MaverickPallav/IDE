package command;

import observer.FileEditor;

// Command Pattern - Undo Command
public class UndoCommand implements Command {
    private FileEditor fileEditor;
    private String prevContent;

    public UndoCommand(FileEditor fileEditor) {
        this.fileEditor = fileEditor;
        this.prevContent = fileEditor.getContent();
    }

    @Override
    public void execute() {
        System.out.println("Undo operation performed.");
        fileEditor.editContent(prevContent);
    }

    @Override
    public void undo() {
        System.out.println("Redo operation performed.");
        fileEditor.editContent(prevContent);
    }
}
