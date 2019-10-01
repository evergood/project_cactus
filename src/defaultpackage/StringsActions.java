package defaultpackage;

import java.io.IOException;

public class StringsActions {
    public  String makeAnagram(String sentence) throws IOException {
        final String space = " ";
        String inputString;
        if (sentence.length() > 0 & sentence != null){
            inputString = sentence;
        } else {
            throw new IOException();
        }

        StringBuilder outputString = new StringBuilder();
        for (String string : inputString.split(space)){
            outputString = outputString.append(stringReverse(string)).append(" ");
        }
        return outputString.toString().trim();
    }

    private static String stringReverse(String string) {
        String inputString = string;
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] inputStringArray = inputString.toCharArray();
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
        String reversedString = new String(reversedStringArray);
        return reversedString;
    }
}
