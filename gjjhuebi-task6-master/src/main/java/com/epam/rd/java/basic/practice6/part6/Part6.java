package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Part6 {
    
    public String[] getInputDataFromFile(String fileName) {
        StringBuilder str = new StringBuilder();
        try (Scanner file = new Scanner(new File(fileName))) {
            while (file.hasNext()) {
                str.append(file.next()).append(" ");
            }
        } catch (FileNotFoundException e) {
            Thread.currentThread().interrupt();
        }
        return str.toString().split(" ");
    }

    public static void main(String[] args) {
        String input = args[1];
        String task = args[3];

        switch (task) {
            case "frequency":
                Part61 part61 = new Part61();
                Stream<Map.Entry<String, Long>> words = part61.searchOccurrence(input);
                words.forEach(w -> System.out.println(w.getKey() + " ==> " + w.getValue()));
                break;
            case "length":
                Part62 part62 = new Part62();
                Stream<Map.Entry<String, Integer>> wordsLength = part62.searchThreeWordsMaxLength(input);
                wordsLength.forEach(w -> System.out.println(w.getKey() + " ==> " + w.getValue()));
                break;
            case "duplicates":
                Part63 part63 = new Part63();
                Stream<StringBuilder> duplicatesWords = part63.searchDuplicates(input);
                duplicatesWords.forEach(System.out::println);
                break;
            default:
                System.out.print("");
                break;
        }
    }
}
