package com.epam.rd.java.basic.practice1;

public class Part5 {

     static int sumNumber(String[] arguments) {

        int sum = 0;

        int integerNumber = Integer.parseInt(arguments[0]);

        if (integerNumber > 0) {
            char[] charsNumbers = arguments[0].toCharArray();

            for (int i = 0; i < charsNumbers.length; i++) {
                sum = sum + Integer.parseInt(String.valueOf(charsNumbers[i]));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print(sumNumber(args));
    }
	
}
