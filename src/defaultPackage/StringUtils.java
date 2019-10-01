package defaultPackage;

import java.util.*;

public class StringUtils {
    public  String makeAnagram(String sentence) {
        StringBuilder outputString = new StringBuilder();
        for (String string : sentence.split(" ")){
            outputString = outputString.append(stringReverse(string)).append(" ");
        }
        return outputString.toString();
    }

    private static StringBuilder stringReverse(String string) {
        String inputString = string;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] inputStringArray = inputString.toCharArray();
        StringBuilder reversedString = new StringBuilder();
        char[] reversedStringArray = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
                if (alphabet.indexOf(inputString.charAt(i)) == -1) {
                    reversedStringArray[i] = inputString.charAt(i);
                    inputStringArray[i] = '\u0000';
                }
        }
        for (char c:inputStringArray){
            if (c != '\u0000'){
                for (int i = reversedStringArray.length-1; i >= 0; i--){
                    if (reversedStringArray[i] == '\u0000'){
                        reversedStringArray[i] = c;
                        break;
                    }
                }
            }
        }
        for (char c:reversedStringArray){
            reversedString.append(c);
        }
        return reversedString;
    }
}
