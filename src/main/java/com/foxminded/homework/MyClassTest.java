package com.foxminded.homework;

public class MyClassTest {
    public static String printArray (char[][] field){
        String output = new String();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                output = output + field[i][j];
            }
            output = output + "\n";
        }
        return output;
    }

    public static int getDivideResult (char[][] field, int divident, int divisor){
        String result = "";
        String dividentString = String.valueOf(divident);
        for (int i = dividentString.length() + 2; i <= dividentString.length()*2; i++){
            result = result + field[2][i];
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        IntegerDivider integerDivider = new IntegerDivider();
        int divident = 1234500777;
        int divisor = 6;
        char [][] resultField = integerDivider.integerDivide(divident, divisor);
        //System.out.println(printArray(resultField));
        System.out.println(printArray(integerDivider.integerDivide(1234500777, 3)));
        //System.out.println(getDivideResult(resultField, divident, divisor));
    }
}
