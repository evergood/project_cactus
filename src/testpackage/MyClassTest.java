package testpackage;
import defaultpackage.StringsActions;

import java.io.IOException;

public class MyClassTest {
    public static void main(String[] args) throws IOException {
        StringsActions action = new StringsActions();
        String result = action.makeAnagram("rrr44tyyuy877ytyrctrdee4 ee777v");
        System.out.println(result);
    }
}
