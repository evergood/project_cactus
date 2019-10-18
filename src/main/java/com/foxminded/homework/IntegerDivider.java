package com.foxminded.homework;

public class IntegerDivider {

    public void print(char[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public void divide(int divident, int divisor) {
        String dividentString = String.valueOf(divident);
        char divisorChar = Character.forDigit(divisor, 10);
        //char[][] divisionField = new char[dividentString.length() * 2 + 2][dividentString.length() * 3 + 1];
        char[][] divisionField = new char[dividentString.length() * 2 + 4][dividentString.length() * 3 + 1];
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
        int n = dividentString.length()+2;

        while (k <= dividentString.length()){
            if (middleResult(divisionField, m, k) < divisor) {
                divisionField[m][++k] = divisionField[0][k];
            }
            else if (middleResult(divisionField, m, k) >= divisor) {
                divisionField[++m][k] = Character.forDigit(middleResult(divisionField, m-1, k)/divisor*divisor%10, 10);
                divisionField[m+1][k] = '-';
                if (middleResult(divisionField, m-1, k)/divisor*divisor/10 > 0 ){
                    divisionField[m][k-1] = Character.forDigit(middleResult(divisionField, m-1, k)/divisor*divisor/10, 10);
                    divisionField[m+1][k-1] = '-';
                }
                m++;
                divisionField[++m][k] = Character.forDigit(middleResult(divisionField, m-3, k) - middleResult(divisionField, m-2, k), 10);
               if (k != dividentString.length()){
                   divisionField[m][++k] = divisionField[0][k];
               }
               else k++;
            }
        }

        print(divisionField);
    }

    private int middleResult(char[][] field, int row, int column) {
        int d;
        if (Character.isDigit(field[row][column-1])){
            d =  Character.getNumericValue(field[row][column-1]) * 10 + Character.getNumericValue(field[row][column]);
        }
        else{
            d = Character.getNumericValue(field[row][column]);
        }
        return d;
    }
}
