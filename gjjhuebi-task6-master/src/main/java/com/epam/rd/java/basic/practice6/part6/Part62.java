package com.epam.rd.java.basic.practice6.part6;

import java.util.*;
import java.util.stream.Stream;

public class Part62 {
    
    public Stream<Map.Entry<String, Integer>> searchThreeWordsMaxLength(String fileName) {
        Part6 part6 = new Part6();

        String[] dataFromFile = part6.getInputDataFromFile(fileName);

        List<String> textList = new ArrayList<>(Arrays.asList(dataFromFile));

        Map<String, Integer> linkedHashMap = textList.stream()
                .collect(LinkedHashMap::new, (map, item) -> map.put(item, item.length()), Map::putAll);

        return linkedHashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
    }
}
