import defaultpackage.StringsActions;
import org.junit.Test;
import static junit.framework.Assert.*;

public class StringActionsTest {
    @Test
    public void actionsTest(){
        StringsActions actions = new StringsActions();
        String result = actions.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", result);
        try{
            actions.makeAnagram("");
            fail("Exception was expected");
        } catch (IllegalArgumentException e) {
        }
        try{
            actions.makeAnagram(null);
            fail("Exception was expected");
        } catch (NullPointerException e){
        }
    }
}
