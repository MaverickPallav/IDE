package observer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

// Observer Pattern - FileManager with Notifier
public class FileManager {
    private List<FileChangeListener> listeners = new CopyOnWriteArrayList<>(); // Thread-safe list
    private Map<String, FileEditor> openFiles = new ConcurrentHashMap<>(); // Thread-safe map

    public void addListener(FileChangeListener listener) {
        listeners.add(listener);
    }

    public void openFile(String fileName, String content) {
        FileEditor fileEditor = new FileEditor(content);
        openFiles.put(fileName, fileEditor);
        notifyListeners(fileName);
    }

    public void editFile(String fileName, String newContent) {
        FileEditor fileEditor = openFiles.get(fileName);
        if (fileEditor != null) {
            fileEditor.editContent(newContent);
            notifyListeners(fileName);
        } else {
            System.out.println("File not found.");
        }
    }

    private void notifyListeners(String fileName) {
        for (FileChangeListener listener : listeners) {
            listener.onFileChanged(fileName);
        }
    }

    public FileEditor getFileEditor(String fileName) {
        return openFiles.get(fileName);
    }
}
