package com.epam.rd.java.basic.practice3;

public class Part5 {

    public static void main(String[] args) {
        System.out.print(decimal2Roman(4));
        System.out.print(roman2Decimal("LXXXVII"));
    }

    private static int subDigit(char numberOne, char numberTwo, int i, Character[] arraySymbols) {
        arraySymbols[i++] = numberOne;
        arraySymbols[i++] = numberTwo;
        return i;
    }


    private static int digit(char symbol, int n, int i, Character[] arraySymbols) {
        for (int j = 0; j < n; j++) {
            arraySymbols[i++] = symbol;
        }
        return i;
    }

    public static String decimal2Roman(int dec) {
        int i = 0;

        int tmpDecimal = dec;

        Character[] romanSymbols = new Character[10001];

        while (dec != 0 && dec < 100) {

            if (dec < 90) {
                i = digit('L', dec / 50, i, romanSymbols);
                dec = dec % 50;
            } else {
                i = subDigit('X', 'C', i, romanSymbols);
                dec = dec % 10;
            }

            if (dec < 40) {
                i = digit('X', dec / 10, i, romanSymbols);
                dec = dec % 10;
            } else {
                i = subDigit('X', 'L', i, romanSymbols);
                dec = dec % 10;
            }
            if (dec < 9) {
                i = digit('V', dec / 5, i, romanSymbols);
                dec = dec % 5;
            } else {
                i = subDigit('I', 'X', i, romanSymbols);
                dec = 0;
            }
            if (dec < 4) {
                i = digit('I', dec, i, romanSymbols);
                dec = 0;
            } else {
                i = subDigit('I', 'V', i, romanSymbols);
                dec = 0;
            }
        }
        return foundSymbols(i, romanSymbols, tmpDecimal);
    }
    
     private static String foundSymbols(int i, Character[] romanSymbols, int decimal) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < i; j++) {
            stringBuilder.append(romanSymbols[j]);
        }
        final String[] emptySymbol = {" "};
        if (decimal <= 0 || decimal > 100) {
            return emptySymbol[0];
        }
        return stringBuilder.toString();
    }

    private static int valuesOfRoman(char roman) {
        if (roman == 'I') {
            return 1;
        }
        if (roman == 'V') {
            return 5;
        }
        if (roman == 'X') {
            return 10;
        }

        if (roman == 'L') {
            return 50;
        }

        if (roman == 'C') {
            return 100;
        }
        return -1;
    }

    public static int roman2Decimal(String roman) {
       int result = 0;

        for (int i = 0; i < roman.length(); i++) {

            int s1 = valuesOfRoman(roman.charAt(i));

            if (i + 1 < roman.length()) {
                int s2 = valuesOfRoman(roman.charAt(i + 1));
                if (s1 >= s2) {
                    result = result + s1;
                } else {
                    result = result + s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
            }
        }
        return result;
    }
}
