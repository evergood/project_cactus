import defaultpackage.StringsActions;
import org.junit.Test;

import static junit.framework.Assert.*;

public class StringActionsTest {
    @Test
    public void resultsShouldBeEqual() {
        StringsActions actions = new StringsActions();
        String result = actions.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroStringShouldThrowException() {
        StringsActions action = new StringsActions();
        action.makeAnagram("");
    }

    @Test(expected = NullPointerException.class)
    public void nullStringShouldThrowException() {
        StringsActions action = new StringsActions();
        action.makeAnagram(null);
    }
}

