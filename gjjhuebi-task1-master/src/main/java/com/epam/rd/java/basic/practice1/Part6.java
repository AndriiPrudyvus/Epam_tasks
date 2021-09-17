package com.epam.rd.java.basic.practice1;

public class Part6 {
    
     static int[] findPrimeNumbers(String[] arguments) {

        String argument = arguments[0];

        if (argument.equals(" ")) {
            return new int[]{};
        } else {
            int integer = Integer.parseInt(arguments[0]);
            int[] array = new int[integer];
            int number = 1000000;
            int m = 0;
            int l = 0;
            int z = 0;

            for (int i = 2; i < number; i++) {
                for (int j = 1; j <= i; j++) {
                    if (i % j == 0) {
                        m++;
                    }
                }
                if (integer == z) {
                    break;
                }
                if (m == 2) {
                    array[l] = i;
                    l++;
                    z++;
                }
                m = 0;
            }
            return array;
        }
    }

    public static void main(String[] args) {
        int[] primeNumbers = findPrimeNumbers(args);

        if (primeNumbers.length != 0) {
            for (int i = 0; i < primeNumbers.length; i++) {
                if (i < primeNumbers.length - 1)
                    System.out.print(primeNumbers[i] + " ");
            }
            System.out.print(primeNumbers[primeNumbers.length - 1]);
        }
    }
	
}
