package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part61{
    
    public Stream<Map.Entry<String, Long>> searchOccurrence(String fileName) {
        Part6 part6 = new Part6();

        String[] text = part6.getInputDataFromFile(fileName);

        List<String> textList = new ArrayList<>(Arrays.asList(text));

        Map<String, Long> linkedHashMap = textList.stream()
                .collect(Collectors.groupingBy(w -> w, LinkedHashMap::new, Collectors.counting()));
        return linkedHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .sorted(Map.Entry.<String, Long>comparingByKey().reversed());
    }
}
