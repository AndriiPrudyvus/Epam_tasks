package com.epam.rd.java.basic.practice3;

public class Part2 {

    public static void main(String[] args) {
        String input = Util.getInput("part2.txt");

        System.out.print(convert(input));
    }

    public static String convert(String input) {
        final String[] words = input.replaceAll("[\n',-]", " ").split(" ");

        String maxWord = words[0];
        String minWord = words[0];

        StringBuilder maxWords = new StringBuilder("Max: ");
        StringBuilder minWords = new StringBuilder("Min: ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= maxWord.length()) {
                maxWord = words[i];
            } else if (words[i].length() <= minWord.length() && !words[i].isEmpty()) {
                minWord = words[i];
            }
        }


        for (int i = 0; i < words.length; i++) {
            if (!maxWords.toString().contains(words[i]) && !minWords.toString().contains(words[i])) {
                if (words[i].length() == maxWord.length()) {
                    maxWords.append(words[i]).append(", ");
                } else if (words[i].length() == minWord.length()) {
                    minWords.append(words[i]).append(", ");
                }
            }
        }
        maxWords.setLength(maxWords.length() - 2);
        minWords.setLength(minWords.length() - 2);
        return minWords.append("\n").append(maxWords).toString();
    }
}
