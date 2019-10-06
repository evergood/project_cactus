import com.foxminded.lms.AnagramaMaker;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.*;

public class StringActionsTest {
    private final AnagramaMaker action = new AnagramaMaker();

    @Rule
    public final ExpectedException e = ExpectedException.none();

    @Test
    public void shouldReturnAnagram() {
        String result = action.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyArgument() {
        action.makeAnagram("");
        e.expect(IllegalArgumentException.class);
        e.expectMessage("The sentence is empty or contains only tabulation symbols");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForSpaceArgument() {
        action.makeAnagram("  ");
        e.expect(IllegalArgumentException.class);
        e.expectMessage("The sentence is empty or contains only tabulation symbols");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullArgument() {
        action.makeAnagram(null);
        e.expect(IllegalArgumentException.class);
        e.expectMessage("The sentence is null");
    }
}

