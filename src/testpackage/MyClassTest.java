package testpackage;
import com.foxminded.lms.AnagramaMaker;

public class MyClassTest {
    public static void main(String[] args) {
        AnagramaMaker action = new AnagramaMaker();
        String result = action.makeAnagram("t555re6");
        System.out.println(result);
    }
}
