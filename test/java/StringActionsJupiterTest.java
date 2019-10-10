import static org.junit.jupiter.api.Assertions.assertEquals;
import  static org.junit.jupiter.api.Assertions.assertThrows;

import com.foxminded.lms.AnagramaMaker;
import org.junit.jupiter.api.Test;

public class StringActionsJupiterTest {
    private final AnagramaMaker action = new AnagramaMaker();

    @Test
    void shouldReturnAnagram() {
        String result = action.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test
    void shouldThrowExceptionForEmptyArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> action.makeAnagram(""));
        assertEquals(exception.getMessage(), "The sentence is empty or contains only tabulation symbols");
    }

    @Test
    void shouldThrowExceptionForSpaceArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> action.makeAnagram(" "));
        assertEquals(exception.getMessage(), "The sentence is empty or contains only tabulation symbols");
    }

    @Test
    void shouldThrowExceptionForNullArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> action.makeAnagram(null));
        assertEquals(exception.getMessage(), "The sentence is null");
    }
}
