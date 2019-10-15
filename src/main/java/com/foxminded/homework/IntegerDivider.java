package com.foxminded.homework;

public class IntegerDivider {
    public  void divide(int divident, int divisor){
        String dividentString = String.valueOf(divident);
        char[][] divisionField = new char[dividentString.length()*2+2][dividentString.length()*3+1];
        divisionField[0][0] = '_';
        for(int i = 1; i <= dividentString.length(); i++){
            divisionField[0][i] = dividentString.charAt(i-1);
        }

        for (int i = 0; i < divisionField.length; i++) {
            for (int j = 0; j < divisionField[i].length; j++) {
                System.out.print(divisionField[i][j]);
            }
            System.out.println();
        }
    }
}
