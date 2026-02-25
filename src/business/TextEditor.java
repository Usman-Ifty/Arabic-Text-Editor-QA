package business;

import java.io.File;

public class TextEditor {

    public boolean importDocument(String filePath) {
        ImportCommand cmd = new ImportCommand(filePath);
        return cmd.execute();
    }

    public boolean saveDocument(String fileName, String content) {
        SaveCommand cmd = new SaveCommand(fileName, content);
        return cmd.execute();
    }

    public boolean exportDocument(String content, String fileName) {
        ExportCommand cmd = new ExportCommand(content, fileName);
        return cmd.execute();
    }

    public boolean transliterateText(int pageId, String text) {
        TransliterateCommand cmd = new TransliterateCommand(pageId, text);
        return cmd.execute();
    }

    public boolean checkAutoSave(String content) {
        if (content == null || content.trim().isEmpty()) {
            return false;
        }
        String[] words = content.trim().split("\\s+");
        return words.length > 500;
    }
}
