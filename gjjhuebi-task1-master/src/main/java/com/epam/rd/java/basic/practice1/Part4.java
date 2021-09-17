package com.epam.rd.java.basic.practice1;

public class Part4 {
    
     static int[] findGreatestDivisor(String[] arguments) {

        int valueOne = Integer.parseInt(arguments[0]);

        int valueTwo = Integer.parseInt(arguments[1]);

        while (valueOne != 0 && valueTwo != 0) {
            if (valueOne > valueTwo) {
                valueOne = valueOne % valueTwo;
            } else {
                valueTwo = valueTwo % valueOne;
            }
        }

        int[] array = new int[2];
        array[0] = valueOne;
        array[1] = valueTwo;
        return array;
    }

    public static void main(String[] args) {
        
        int[] greatestDivisor = findGreatestDivisor(args);

        if (greatestDivisor[0] > greatestDivisor[1]) {
            System.out.print(greatestDivisor[0]);
        } else {
            System.out.print(greatestDivisor[1]);
        }
        
    }

}
