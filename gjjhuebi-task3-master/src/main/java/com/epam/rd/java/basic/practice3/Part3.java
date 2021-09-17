package com.epam.rd.java.basic.practice3;

public class Part3 {

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");

        System.out.print(convert(input));
    }

    public static String convert(String input) {
        StringBuilder outPutResult = new StringBuilder();

        final String[] words = input.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() >= 3) {

                final char firstSymbol = words[i].charAt(0);

                if (Character.isUpperCase(firstSymbol)) {
                    words[i] = words[i].replace(firstSymbol, Character.toLowerCase(firstSymbol));
                }

                if (Character.isLowerCase(firstSymbol)) {
                    words[i] = words[i].replace(firstSymbol, Character.toUpperCase(firstSymbol));
                }
            }

            outPutResult.append(words[i]);

            if (i != words.length - 1) {
                outPutResult.append(" ");
            }
        }
        return outPutResult.toString();
    }
}
