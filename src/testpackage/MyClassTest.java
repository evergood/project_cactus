package testpackage;
import defaultpackage.AnagramaMaker;

public class MyClassTest {
    public static void main(String[] args) {
        AnagramaMaker action = new AnagramaMaker();
        String result = action.makeAnagram(null);
        System.out.println(result);
    }
}
