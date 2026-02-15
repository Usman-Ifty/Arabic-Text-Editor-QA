package testing.data;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dal.DatabaseConnection;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

class SingletonTests {
    
    @Test
    void testSingletonSameInstance() {
        // Act
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        
        // Assert
        assertSame(instance1, instance2, "getInstance() should always return the same object");
    }
    
    @Test
    void testPrivateConstructor() {
        // Act
        Constructor<?>[] constructors = DatabaseConnection.class.getDeclaredConstructors();
        
        // Assert
        assertEquals(1, constructors.length, "Singleton should have only one constructor");
        assertTrue(Modifier.isPrivate(constructors[0].getModifiers()), "Constructor must be private");
    }
}
