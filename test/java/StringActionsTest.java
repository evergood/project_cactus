import defaultpackage.AnagramaMaker;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class StringActionsTest {
    private final AnagramaMaker action = new AnagramaMaker();

    @Test
    public void resultsShouldBeEqual() {
        String result = action.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroStringShouldThrowException() {
        try {
            action.makeAnagram("");
        } catch (IllegalArgumentException e){
            String message = "The sentence must not be empty";
            assertEquals(e.getMessage(),message);
            throw e;
        }
        fail("Illegal argument exception hasn't been thrown");
    }

    @Test(expected = NullPointerException.class)
    public void nullStringShouldThrowException() {
        try {
            action.makeAnagram(null);
        }catch (NullPointerException e){
            String message = "The sentence must not be null";
            assertEquals(e.getMessage(),message);
            throw e;
        }
        fail("Null pointer exception hasn't been thrown");
    }
}

