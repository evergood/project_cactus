import com.foxminded.lms.AnagramaMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringActionsTest {
    private final AnagramaMaker anagramaMaker = new AnagramaMaker();

    @Test
    void shouldReturnAnagram() {
        String result = anagramaMaker.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test
    void shouldThrowExceptionForEmptyArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> anagramaMaker.makeAnagram(""));
        assertEquals(exception.getMessage(), "The sentence is empty or contains only tabulation symbols");
    }

    @Test
    void shouldThrowExceptionForSpaceArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> anagramaMaker.makeAnagram(" "));
        assertEquals(exception.getMessage(), "The sentence is empty or contains only tabulation symbols");
    }

    @Test
    void shouldThrowExceptionForNullArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> anagramaMaker.makeAnagram(null));
        assertEquals(exception.getMessage(), "The sentence is null");
    }
}
