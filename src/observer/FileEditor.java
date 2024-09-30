package observer;

// Observer Pattern - Editor as a Listener
public class FileEditor implements FileChangeListener {
    private String content;

    public FileEditor(String content) {
        this.content = content;
    }

    @Override
    public void onFileChanged(String fileName) {
        System.out.println(fileName + " has been modified.");
    }

    public synchronized void editContent(String newContent) { // Synchronizing this method
        this.content = newContent;
        System.out.println("File content edited.");
    }

    public synchronized String getContent() { // Synchronizing this method
        return content;
    }
}
