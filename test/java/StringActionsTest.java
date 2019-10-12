import com.foxminded.homework.AnagramaMaker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringActionsTest {
    private final AnagramaMaker anagramaMaker = new AnagramaMaker();

    @Test
    void makeAnagramShouldReturnAnagramForOneWordWithNumbersAndNoSymbolsArgument(){
        String actual = anagramaMaker.makeAnagram("tt44ews76i");
        assertEquals("is44wet76t", actual);
    }

    @ParameterizedTest
    @CsvSource({"a,a","aaa,aaa","AAAAA,AAAAA","AAAaaaA,AaaaAAA"})
    void makeAnagramShouldReturnAnagramForOneWordOneLetterArgumentInDifferentCases(String input,String expected){
        assertEquals(anagramaMaker.makeAnagram(input),expected);
    }

    @ParameterizedTest
    @CsvSource({"abc def,cba fed","sugh iuhs,hgus shui ","rt ew,tr we"})
    void makeAnagramShouldReturnAnagramForTwoWordOnlyLettersArgument(String input, String expected){
        assertEquals(anagramaMaker.makeAnagram(input),expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","1244235","(&^(%@!%<><^{:","876*%!76&%@!((^&^&",})
    void makeAnagramShouldKeepOneWordNonletterArgumentsTheSame(String input){
        assertEquals(anagramaMaker.makeAnagram(input),input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12442 35","(&^(%@!% <><^{:","876*%!7 6&%@!((^&^&",})
    void makeAnagramShouldKeepTwoWordsNonletterArgumentsTheSame(String input){
        assertEquals(anagramaMaker.makeAnagram(input),input);
    }

    @ParameterizedTest
    @CsvSource({"ab3c d1ef,cb3a f1ed","su@gh i!!uhs,hg@us s!!hui ","rt# %ew,tr# %we"})
    void makeAnagramShouldReturnAnagramForTwoWordLetterAndNonletterArgument(String input, String expected){
        assertEquals(anagramaMaker.makeAnagram(input),expected);
    }

    @ParameterizedTest
    @CsvSource({"ab3c d1ef i55r,cb3a f1ed r55i","su@gh i!!uhs s**re,hg@us s!!hui e**rs","rt# %ew !34,tr# %we !34"})
    void makeAnagramShouldReturnAnagramForSeveralWordLetterAndNonletterArgument(String input, String expected){
        assertEquals(anagramaMaker.makeAnagram(input),expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","        ","             "})
    void makeAnagramShouldThrowExceptionForEmptyAndSpacesOnlyArgument(String input){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> anagramaMaker.makeAnagram(input));
        assertEquals(exception.getMessage(), "The sentence is empty or contains only tabulation symbols");
    }

    @Test
    void makeAnagramShouldThrowExceptionForNullArgument(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> anagramaMaker.makeAnagram(null));
        assertEquals(exception.getMessage(), "The sentence is null");
    }
}
