package business;

public class ExportCommand implements ICommand {
    private String content;
    private String fileName;

    public ExportCommand(String content, String fileName) {
        this.content = content;
        this.fileName = fileName;
    }

    @Override
    public boolean execute() {
        // Implementation for exporting file
        // For now, return true as a placeholder for testing
        return true;
    }
}
