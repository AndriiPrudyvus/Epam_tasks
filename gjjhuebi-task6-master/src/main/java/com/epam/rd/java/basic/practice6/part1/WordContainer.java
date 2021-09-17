package com.epam.rd.java.basic.practice6.part1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordContainer {
	
	private TreeSet<Word> words;

    private int countFrequency;

    public WordContainer() {
        Comparator<Word> comparator = Comparator
                .comparingInt(Word::getFrequency).thenComparing(Word::getContent);
        words = new TreeSet<>(comparator);
    }


    public List<String> parseLines(String lines) {
        return Stream.of(lines
                .split(" "))
                .filter(s -> !s.equals(""))
                .map(String::new)
                .collect(Collectors.toList());
    }


    public NavigableSet<Word> addWordsToTree(List<String> arrayWords) {
        List<String> str = new ArrayList<>();

        for (String arrayWord : arrayWords) {
            if (arrayWord.equals("stop")) {
                break;
            }
            str.add(arrayWord);
        }

        for (int i = 0; i < str.size(); i++) {
            Word word = new Word();
            String s = str.get(i);

            for (int j = 0; j < str.size(); j++) {
                if (s.equals(str.get(j))) {
                    countFrequency++;
                }
            }
            word.setContent(s);
            word.setFrequency(countFrequency);
            countFrequency = 0;
            words.add(word);
        }
        return words;
    }


    public void printResult(NavigableSet<Word> words) {
        Comparator<Word> comparator = Comparator.comparingInt(Word::getFrequency);
        words.stream()
                .sorted(comparator.reversed())
                .forEach(System.out::println);
    }


    public String readDataFromConsole() {
        Scanner scanner = new Scanner(System.in);

        StringBuilder readLines = new StringBuilder();
        String line;
        while (!(line = scanner.next()).equals("stop")) {
            readLines.append(line).append(" ");
        }
        return readLines.toString();
    }
    
    
	public static void main(String[] args) {
	    WordContainer wordContainer = new WordContainer();

        List<String> parsedLines = wordContainer.parseLines(wordContainer.readDataFromConsole());

        NavigableSet<Word> wordsInTreeCounted = wordContainer.addWordsToTree(parsedLines);

        wordContainer.printResult(wordsInTreeCounted);

        wordsInTreeCounted.clear();
	}
}
