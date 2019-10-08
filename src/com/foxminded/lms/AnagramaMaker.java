package com.foxminded.lms;

public class AnagramaMaker {

    static final String SPACE = " ";

    public  String makeAnagram(String sentence)  {
        validate(sentence);

        StringBuilder outputString = new StringBuilder();
        for (String string : sentence.split(SPACE)){
            outputString = outputString.append(stringReverse(string)).append(SPACE);
        }
        return outputString.toString().trim();
    }

    private static void validate (String inputString){
        if (inputString == null) {
            throw new IllegalArgumentException("The sentence is null");
        }
        if (inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("The sentence is empty or contains only tabulation symbols");
        }
    }

    private static String stringReverse(String inputString) {
        char[] reversedString = new char[inputString.length()];
        int j = inputString.length()-1;
        for(int i = 0; i < inputString.length(); i++){
            if (!Character.isLetter(inputString.charAt(i))){
                reversedString[i] = inputString.charAt(i);
            } else {
                while (!Character.isLetter(inputString.charAt(j))){
                    j--;
                }
                reversedString[j--] = inputString.charAt(i);
            }
        }

        return new String(reversedString);
    }
}
