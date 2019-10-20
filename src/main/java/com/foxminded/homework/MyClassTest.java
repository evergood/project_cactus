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

    public static void main(String[] args) {
        IntegerDivider integerDivider = new IntegerDivider();
        System.out.println(printArray(integerDivider.integerDivide(100345, 5)));
    }
}
