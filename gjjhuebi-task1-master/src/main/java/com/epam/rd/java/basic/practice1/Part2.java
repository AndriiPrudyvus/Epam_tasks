package com.epam.rd.java.basic.practice1;

public class Part2 {
    
    static String getFirstElement(String firstElement) {
        return firstElement;
    }

    static String getSecondElement(String secondElement) {
        return secondElement;
    }

    static Integer getFirstNumber(String firstNumber) {
        return Integer.valueOf(firstNumber);
    }

    static Integer getSecondNumber(String secondNumber) {
        return Integer.valueOf(secondNumber);
    }

    static Integer addNumbers(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    public static void main(String[] args) {
        
        String firstElement = getFirstElement(args[0]);

        String secondElement = getSecondElement(args[1]);

        int firstNumber = getFirstNumber(firstElement);

        int secondNumber = getSecondNumber(secondElement);

        System.out.print(addNumbers(firstNumber, secondNumber));
    }
	
}
