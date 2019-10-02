package defaultpackage;

public class StringsActions {
    final static String space = " ";
    public  String makeAnagram(String sentence)  {
        validate(sentence);
        StringBuilder outputString = new StringBuilder();
        for (String string : sentence.split(space)){
            outputString = outputString.append(stringReverse(string)).append(" ");
        }
        return outputString.toString().trim();
    }

    private static void validate (String string){
        if (string.length()<=0){
            throw new IllegalArgumentException();
        } else if (string == null){
            throw new NullPointerException();
        } else return;
    }


    private static String stringReverse(String string) {
        char[] inputStringArray = string.toCharArray();
        char[] reversedStringArray = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
                if (!Character.isLetter(string.charAt(i))) {
                    reversedStringArray[i] = string.charAt(i);
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
