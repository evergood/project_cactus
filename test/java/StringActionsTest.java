import defaultpackage.StringsActions;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class StringActionsTest {
    private static StringsActions action;

    @Before
    public  void createAction(){
        action = new StringsActions();
    }

    @Test
    public void resultsShouldBeEqual() {
        String result = action.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroStringShouldThrowException() {
        action.makeAnagram("");
    }

    @Test(expected = NullPointerException.class)
    public void nullStringShouldThrowException() {
        action.makeAnagram(null);
    }
}

