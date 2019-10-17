package com.foxminded.homework;

public class IntegerDivider {
    public void divide(int divident, int divisor) {
        String dividentString = String.valueOf(divident);
        char divisorChar = Character.forDigit(divisor, 10);
        char[][] divisionField = new char[dividentString.length() * 2 + 2][dividentString.length() * 3 + 1];
        divisionField[0][0] = '_';
        for (int i = 1; i <= dividentString.length(); i++) {
            divisionField[0][i] = dividentString.charAt(i - 1);
        }
        divisionField[0][dividentString.length() + 1] = '|';
        divisionField[1][dividentString.length() + 1] = '|';
        divisionField[2][dividentString.length() + 1] = '|';
        divisionField[0][dividentString.length() + 2] = Character.forDigit(divisor, 10);

        int m = 0;
        int k = 1;

        for (int i = 1; i < dividentString.length(); i++) {
            k = i;
            if (middleResult(divisionField, m, k) > divisor) {
                k = i;
                divisionField[++m][k] = divisorChar;
                divisionField[++m][k] = '-';
                divisionField[++m][k] = Character.forDigit(Character.getNumericValue(divisionField[m - 3][k]) % divisor, 10);
                divisionField[m][++k] = divisionField[0][k];
            }
        }


        for (int i = 0; i < divisionField.length; i++) {
            for (int j = 0; j < divisionField[i].length; j++) {
                System.out.print(divisionField[i][j]);
            }
            System.out.println();
        }
    }

    private int middleResult(char[][] field, int row, int column) {
        if (Character.isDigit(field[row][column-1])){
            return Character.getNumericValue(field[row][column-1]) * 10 + Character.getNumericValue(field[row][column]);
        }
        else return Character.getNumericValue(field[row][column]);
    }
}
