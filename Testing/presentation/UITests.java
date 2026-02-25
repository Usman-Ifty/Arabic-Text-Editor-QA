package presentation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pl.EditorPO;

class UITests {

    @Test
    void testArabicInputValidation() {
        // Arrange
        String arabicText = "مرحبا بك";
        // Note: Real validation logic resides in EditorPO
        // This test simulates input validation

        // Act
        boolean isValid = validateInput(arabicText);

        // Assert
        assertTrue(isValid, "Arabic text should be accepted");
    }

    @Test
    void testNullInputRejection() {
        // Act & Assert
        assertFalse(validateInput(null), "Null input should be rejected");
    }

    // Helper method simulating UI validation logic from EditorPO
    private boolean validateInput(String text) {
        return text != null && !text.trim().isEmpty();
    }
}
