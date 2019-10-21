package java;

import com.foxminded.homework.IntegerDivider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerDividerTest {
    private final IntegerDivider integerDivider = new IntegerDivider();

    @Test
    void shouldReturnDivisionResultInArray(){
        final int result = getDivideResult(integerDivider.integerDivide(12345,6),12345,6);
        final int expected = 12345/6;
        assertEquals(expected, result);
    }

    private static int getDivideResult (char[][] field, int divident, int divisor){
        String result = new String();
        String dividentString = String.valueOf(divident);
        for (int i = dividentString.length() + 2; i <= dividentString.length()*2; i++){
            result = result + field[2][i];
        }
        return Integer.parseInt(result);
    }

}
