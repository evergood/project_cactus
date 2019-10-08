import com.foxminded.lms.AnagramaMaker;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.*;

public class StringActionsTest {
    private final AnagramaMaker action = new AnagramaMaker();

    @Rule
    public  ExpectedException e = ExpectedException.none();

    @Test
    public void shouldReturnAnagram() {
        String result = action.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test
    public void shouldThrowExceptionForEmptyArgument() {
        e.expect(IllegalArgumentException.class);
        e.expectMessage("The sentence is empty or contains only tabulation symbols");
        action.makeAnagram("");
    }

    @Test
    public void shouldThrowExceptionForSpaceArgument() {
        e.expect(IllegalArgumentException.class);
        e.expectMessage("The sentence is empty or contains only tabulation symbols");
        action.makeAnagram("  ");
    }

    @Test
    public void shouldThrowExceptionForNullArgument(){
        e.expect(IllegalArgumentException.class);
        e.expectMessage("The sentence is null");
        action.makeAnagram(null);
    }
}

