import defaultpackage.StringsActions;
import org.junit.Test;
import static junit.framework.Assert.*;

public class StringActionsTest {
    @Test
    public void actionsTest() throws Exception{
        StringsActions actions = new StringsActions();
        String result = actions.makeAnagram("tt44ews76i");

        assertEquals("is44wet76t", result);
    }
}
