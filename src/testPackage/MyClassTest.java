package testPackage;
import defaultPackage.StringUtils;

public class MyClassTest {
    public static void main(String[] args) {
        StringUtils util = new StringUtils();
        String result = util.makeAnagram("rrr44t ee777v");
        System.out.println(result);
    }
}
