package com.foxminded.homework;

public class IntegerDivider {

    public char[][] integerDivide(int divident, int divisor) {
        validate(divident, divisor);
        return divide(divident, divisor);
    }

    private static void validate(int inputDivident, int inputDivisor) {
        if (inputDivisor == 0) {
            throw new IllegalArgumentException("Can't divide by zero");
        }
        if (inputDivident <= 0 || inputDivisor < 0) {
            throw new IllegalArgumentException("Don't use negative or zero arguments");
        }
    }

    private char[][] divide(int divident, int divisor) {
        String dividentString = String.valueOf(divident);
        char[][] divisionField = new char[dividentString.length() * 2 + 4][dividentString.length() * 3 + 1];
        for (int i = 1; i <= dividentString.length(); i++) {
            divisionField[0][i] = dividentString.charAt(i - 1);
        }
        divisionField[0][dividentString.length() + 1] = '|';
        divisionField[1][dividentString.length() + 1] = '|';
        divisionField[2][dividentString.length() + 1] = '|';
        divisionField[0][dividentString.length() + 2] = Character.forDigit(divisor, 10);

        int m = 0; //row
        int k = 1; //column
        int n = dividentString.length() + 2; // result pointer

        while (k <= dividentString.length()) {
            if (middleResult(divisionField, m, k) < divisor) {
                if (k != 1) {
                    divisionField[2][n] = '0';
                    divisionField[1][n++] = '-';
                }
                if (isEligibleForTransferAfterZeroResultDigit(divisionField, m, k)) {
                    divisionField[m][++k] = divisionField[0][k];
                }
            } else {
                divisionField[++m][k] = Character.forDigit(middleResult(divisionField, m - 1, k) / divisor * divisor % 10, 10);
                divisionField[2][n] = Character.forDigit(middleResult(divisionField, m - 1, k) / divisor, 10);
                divisionField[1][n++] = '-';
                divisionField[m + 1][k] = '-';
                if (middleResult(divisionField, m - 1, k) / divisor * divisor / 10 > 0) {
                    divisionField[m][k - 1] = Character.forDigit(middleResult(divisionField, m - 1, k) / divisor * divisor / 10, 10);
                    divisionField[m + 1][k - 1] = '-';
                }
                if (Character.isDigit(divisionField[m - 1][k - 1]) && Character.getNumericValue(divisionField[m - 1][k - 1]) != 0) {
                    divisionField[m - 1][k - 2] = '_';
                } else {
                    divisionField[m - 1][k - 1] = '_';
                }
                m++;
                if (middleResult(divisionField, m - 2, k) > middleResult(divisionField, m - 1, k) || k == dividentString.length()) {
                    divisionField[++m][k] = Character.forDigit(middleResult(divisionField, m - 3, k) - middleResult(divisionField, m - 2, k), 10);
                } else m++;
                if (isEligibleForTransferAfterDifferenceCalculation(divisionField, m,  k, dividentString)) {
                    divisionField[m][++k] = divisionField[0][k];
                } else k++;
            }
        }

        return divisionField;
    }

    private static int middleResult(char[][] field, int row, int column) {
        return Character.isDigit(field[row][column - 1]) ? Character.getNumericValue(field[row][column - 1]) * 10 + Character.getNumericValue(field[row][column]) : Character.getNumericValue(field[row][column]);
    }

    private static boolean isEligibleForTransferAfterZeroResultDigit(char[][] field, int row, int column) {
        return Character.isDigit(field[0][++column]) && (Character.getNumericValue(field[0][column]) > 0 || Character.isDigit(field[row][column - 1]));
    }

    private static boolean isEligibleForTransferAfterDifferenceCalculation(char [][] field, int row, int column, String divident){
        return  column < divident.length() && ((Character.getNumericValue(field[0][column + 1]) > 0 || Character.isDigit(field[row][column])));
    }
}
