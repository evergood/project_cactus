import com.foxminded.homework.IntegerDivider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerDividerTest {
    private final IntegerDivider integerDivider = new IntegerDivider();

    @ParameterizedTest
    @ValueSource (ints = {100,150,200,111,160,303,123})
    void integerDividerShouldReturnDivisionResultWithThreeDigitArguments(int divident){
        final int divisor = 7;
        final char[][] resultField = integerDivider.integerDivide(divident, divisor);
        final int result = getDivideResult(resultField, divident);
        final int expected = divident/divisor;
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource (ints = {10000,15000,20000,11111,16005,30303,12345})
    void integerDividerShouldReturnDivisionResultWithFiveDigitArguments(int divident){
        final int divisor = 7;
        final char[][] resultField = integerDivider.integerDivide(divident, divisor);
        final int result = getDivideResult(resultField, divident);
        final int expected = divident/divisor;
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource (ints = {1000000,1500000,2000000,1111111,1600005,3030303,1234567})
    void integerDividerShouldReturnDivisionResultWithSevenDigitArguments(int divident){
        final int divisor = 7;
        final char[][] resultField = integerDivider.integerDivide(divident, divisor);
        final int result = getDivideResult(resultField, divident);
        final int expected = divident/divisor;
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource (ints = {100000000,150000000,200000000,111111111,160000005,303030303,123456789})
    void integerDividerShouldReturnDivisionResultWithNineDigitArguments(int divident){
        final int divisor = 7;
        final char[][] resultField = integerDivider.integerDivide(divident, divisor);
        final int result = getDivideResult(resultField, divident);
        final int expected = divident/divisor;
        assertEquals(expected, result);
    }

    @Test
    void integerDividerShouldThrownExceptionForZeroDivisor(){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> integerDivider.integerDivide(123,0) );
        assertEquals(exception.getMessage(), "Can't divide by zero");
    }

    @ParameterizedTest
    @CsvSource({"0,7","-10,7","-500,7"})
    void makeAnagramShouldThrowExceptionForZeroAndNegativeDividents(int divident, int divisor){
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> integerDivider.integerDivide(divident,divisor));
        assertEquals(exception.getMessage(), "Don't use negative or zero arguments");
    }



    private static int getDivideResult (char[][] field, int divident){
        String result = new String();
        String dividentString = String.valueOf(divident);
        for (int i = dividentString.length() + 2; i <= dividentString.length()*2; i++){
            result = result + field[2][i];
        }
        return Integer.parseInt(result);
    }

}
