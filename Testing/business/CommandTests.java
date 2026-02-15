package testing.business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import business.ImportCommand;
import business.ExportCommand;
import business.TransliterateCommand;

class CommandTests {
    
    @Test
    void testImportCommandPositive() {
        // Arrange
        String testFile = "test_resource/sample.txt";
        // Create dummy file for testing
        createDummyFile(testFile);
        ImportCommand cmd = new ImportCommand(testFile);
        
        // Act
        boolean result = cmd.execute();
        
        // Assert
        assertTrue(result, "Import should succeed for valid file");
        
        // Cleanup
        new File(testFile).delete();
    }
    
    @Test
    void testImportCommandNegative() {
        // Arrange
        ImportCommand cmd = new ImportCommand("nonexistent_file.txt");
        
        // Act & Assert
        // Assuming execute returns false or throws exception
        try {
            boolean result = cmd.execute();
            assertFalse(result, "Import should fail for non-existent file");
        } catch (Exception e) {
            assertTrue(e instanceof FileNotFoundException);
        }
    }

    private void createDummyFile(String path) {
        try {
            File f = new File(path);
            f.getParentFile().mkdirs();
            f.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
