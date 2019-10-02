package testpackage;
import defaultpackage.StringsActions;

import java.io.IOException;

public class MyClassTest {
    public static void main(String[] args) {
        StringsActions action = new StringsActions();
        String result = action.makeAnagram(null);
        System.out.println(result);
    }
}
