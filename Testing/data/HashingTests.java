package data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dal.HashCalculator;

class HashingTests {

    @Test
    void testMD5HashGeneration() {
        // Arrange
        String content = "Hello World";
        HashCalculator hasher = new HashCalculator();

        // Act
        String hash = hasher.calculateMD5(content);

        // Assert
        assertNotNull(hash);
        assertEquals(32, hash.length(), "MD5 hash should be 32 chars long");
    }

    @Test
    void testHashChangeOnEdit() {
        // Arrange
        String content1 = "Original Text";
        String content2 = "Edited Text";
        HashCalculator hasher = new HashCalculator();

        // Act
        String hash1 = hasher.calculateMD5(content1);
        String hash2 = hasher.calculateMD5(content2);

        // Assert
        assertNotEquals(hash1, hash2, "Hashes must differ for different content");
    }
}
