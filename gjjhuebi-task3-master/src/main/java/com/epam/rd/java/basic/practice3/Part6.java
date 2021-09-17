package com.epam.rd.java.basic.practice3;

public class Part6 {

    public static void main(String[] args) {
        final String inputData = Util.getInput("part6.txt");

        System.out.println(convert(inputData));
    }

    public static String convert(String input) {
        final String[] lines = input.replaceAll("\n", "\r\n ").split("[ \r ]");

        StringBuilder result = new StringBuilder();

        int j = 0;

        for (int i = 0; i < lines.length; i++) {
            for (int k = 0; k < lines.length - 1; k++) {
                if (lines[i].equals(lines[k + 1]) && k != i - 1) {
                    j++;
                }
            }
            if (j == 0) {
                result.append(lines[i]).append(" ");
            } else if (j > 0 && !lines[i].equals("\n")) {
                result.append("_").append(lines[i]).append(" ");
            }

            if (lines[i].equals("\n")) {
                result.setLength(result.length() - 1);
                result.append("\n");
            }
            j = 0;
        }
        result.setLength(result.length() - 1);

        return result.toString();
    }
}
