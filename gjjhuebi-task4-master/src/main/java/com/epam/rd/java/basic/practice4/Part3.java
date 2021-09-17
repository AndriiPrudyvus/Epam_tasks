package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    
    private static String getData(String data) {
        String regex;
        switch (data) {
            case "char":
                regex = "\\b\\p{L}\\b";
                break;
            case "int":
                regex = "(?<!\\.)\\b[0-9]+\\b(?!\\.)";
                break;
            case "double":
                regex = "[0-9]+[\\.\\,][0-9]+";
                break;
            case "String":
                regex = "[\\p{L}]{2,}";
                break;
            default:
                regex = "null";
        }
        return regex;
    }

    private static boolean readUserDataIsCorrect(String inputUser) {
        return inputUser.equalsIgnoreCase("String") || inputUser.equalsIgnoreCase("int")
                || inputUser.equalsIgnoreCase("char") || inputUser.equalsIgnoreCase("double");
    }

    static String getInputFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            //Logger imitation
        }
        return sb.toString();
    }

    static String getResult() {
        String dataFromFile;
        String inputFromUsr;
        Scanner scanner = new Scanner(System.in);
        dataFromFile = getInputFromFile("part3.txt");
        StringBuilder result = new StringBuilder();
        do {

            inputFromUsr = scanner.next();
            if (inputFromUsr.equalsIgnoreCase("stop")) {
                break;
            } else if (readUserDataIsCorrect(inputFromUsr)) {
                Matcher matcher = Pattern.compile(getData(inputFromUsr)).matcher(dataFromFile);
                while (matcher.find()) {
                    result.append(dataFromFile, matcher.start(), matcher.end()).append(" ");
                }
            } else {
                result.append("Incorrect input");
            }
            System.out.println(result.toString());
        } while (true);
        scanner.close();
        return result.toString();
    }
    
    public static void main(String[] args) {
    getResult();
    }
}
