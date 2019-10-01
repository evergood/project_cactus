package tmp;

import java.util.*;

public class StringReverser_old {
    public  void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string to reverse");
        String inputString = scanner.nextLine();
        StringBuilder outputString = new StringBuilder();
        char[] alphabetChar = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<Character> alphabet = new ArrayList<>();
        for(char c : alphabetChar)
            alphabet.add(c);
        for (String string:inputString.split(" "))
            outputString.append(stringReverse(string,alphabet)).append(" ");
        System.out.println(outputString);
    }

    public static StringBuilder stringReverse (String string, List alphabet){
        StringBuilder reversedString = new StringBuilder();
        Map<Integer, Character> charMap = new TreeMap<>();
        for(int i = string.length()-1; i >= 0; i--){
            if(alphabet.contains(string.charAt(i)))
                reversedString.append(string.charAt(i));
             else
                charMap.put(i, string.charAt(i));
        }
        for(Map.Entry<Integer,Character> entry : charMap.entrySet())
            reversedString.insert(entry.getKey(), (Object) entry.getValue());
        return reversedString;
    }
}
