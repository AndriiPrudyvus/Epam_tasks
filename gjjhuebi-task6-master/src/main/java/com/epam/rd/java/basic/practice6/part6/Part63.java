package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part63{
    public Stream<StringBuilder> searchDuplicates(String fileName) {
        Part6 part6 = new Part6();

        String[] text = part6.getInputDataFromFile(fileName);

        List<String> textList = new ArrayList<>(Arrays.asList(text));

        Map<String, Long> linkedHashMap = textList.stream()
                .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));

        return linkedHashMap.entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .limit(3)
                .map(Map.Entry::getKey)
                .map((word -> new StringBuilder(word.toUpperCase()).reverse()));
    }
}
