package testing.business;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dal.TFIDFCalculator;
import java.util.Arrays;
import java.util.List;

class TFIDFTests {
    
    private TFIDFCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new TFIDFCalculator();
    }
    
    @Test
    void testTFIDFPositive() {
        // Arrange
        String docContent = "this is a sample document";
        List<String> corpus = Arrays.asList(
            "this is another document",
            "and this is yet another one",
            "sample document for testing"
        );
        
        // Act
        // Note: Actual method signature depends on implementation
        double score = calculator.calculate(docContent, corpus);
        
        // Assert
        assertTrue(score >= 0.0, "TF-IDF score should be non-negative");
    }
    
    @Test
    void testTFIDFEmpty() {
        // Arrange
        String docContent = "";
        List<String> corpus = Arrays.asList("doc1", "doc2");
        
        // Act
        double score = calculator.calculate(docContent, corpus);
        
        // Assert
        assertEquals(0.0, score, 0.01, "Empty document should have 0 score");
    }
}
