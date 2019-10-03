package defaultpackage;

public class AnagramaMaker {

    static final String SPACE = " ";
    private String sentence;

    public  String makeAnagram(String sentence)  {

        validate(sentence);
        this.sentence = sentence;
        StringBuilder outputString = new StringBuilder();
        for (String string : this.sentence.split(SPACE)){
            outputString = outputString.append(stringReverse(string)).append(SPACE);
        }
        return outputString.toString().trim();
    }

    private static void validate (String inputString){
        if (inputString == null) {
            throw new NullPointerException("The sentence must not be null");
        } else if (inputString.length() == 0) {
            throw new IllegalArgumentException("The sentence must not be empty");
        }
    }

    private static String stringReverse(String inputString) {
        char[] inputStringArray = inputString.toCharArray();
        char[] reversedStringArray = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
                if (!Character.isLetter(inputString.charAt(i))) {
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
        return new String(reversedStringArray);
    }
}
