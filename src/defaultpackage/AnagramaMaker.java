package defaultpackage;

public class AnagramaMaker {

    private final String SPACE = " ";

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
            throw new IllegalArgumentException("The sentence must not be null");
        } else if (inputString.trim().isEmpty()) {
            throw new IllegalArgumentException("The sentence must not be empty");
        }
    }

    private static String stringReverse(String inputString) {
        char[] reversedStringArray = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
                if (!Character.isLetter(inputString.charAt(i))) {
                    reversedStringArray[i] = inputString.charAt(i);
                }
        }
        for (int i = 0; i < inputString.length(); i++){
            if (Character.isLetter(inputString.charAt(i))){
                for (int y = reversedStringArray.length-1; y >= 0; y--){
                    if (reversedStringArray[y] == '\u0000'){
                        reversedStringArray[y] = inputString.charAt(i);
                        break;
                    }
                }
            }
        }
        return new String(reversedStringArray);
    }
}
