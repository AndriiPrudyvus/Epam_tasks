package com.epam.rd.java.basic.practice6.part6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Part6Test {
    
    private Part6 part6;

    private Part61 part61;

    private Part62 part62;

    private Part63 part63;

    @Before
    public void beforeTest() {
        part6 = new Part6();
        part61 = new Part61();
        part62 = new Part62();
        part63 = new Part63();
    }

    @Test
    public void shouldGetInputFromFile() {
        String[] inputDataFromFile = part6.getInputDataFromFile("part6.txt");
        String text = "jaguar chimpanzee bison whale\n" +
                "marmot bison lemur panther camel lizard wolf bear\n" +
                "gecko\n" +
                "mongoose leopard sable sable dingo whale jaguar\n" +
                "rat lemur lemur gorilla zebra tortoise\n" +
                "asp lion tapir tortoise gorilla cheetah bison marten\n" +
                "marmot cheetah camel\n" +
                "snake marmot\n" +
                "zebra asp cheetah lizard gecko gorilla asp lion tortoise\n" +
                "kangaroo whale penguin yak cheetah mouse panther";
        String[] lines = text.split("\n");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            str.append(lines[i]).append(" ");
        }
        String[] expected = str.toString().split(" ");

        Assert.assertArrayEquals(expected, inputDataFromFile);
    }

    @Test
    public void shouldSearchOccur() {
        List<Object> collect = part61.searchOccurrence("part6.txt").collect(Collectors.toList());
        List<Object> expected = new ArrayList<>();
        expected.add("whale=3");
        expected.add("cheetah=4");
        expected.add("bison=3");
        Assert.assertEquals(expected.toString(), collect.toString());
    }


    @Test
    public void shouldSearchLength() {
        List<Map.Entry<String, Integer>> searchedValues = part62.searchThreeWordsMaxLength("part6.txt")
                .collect(Collectors.toList());
        List<Object> expected = new ArrayList<>();
        expected.add("chimpanzee=10");
        expected.add("mongoose=8");
        expected.add("tortoise=8");
        Assert.assertEquals(expected.toString(), searchedValues.toString());
    }


    @Test
    public void shouldSearchDuplicates() {
        List<StringBuilder> searchedValues = part63.searchDuplicates("part6.txt")
                .collect(Collectors.toList());
        List<StringBuilder> expected = new ArrayList<>();
        expected.add(new StringBuilder("RAUGAJ"));
        expected.add(new StringBuilder("NOSIB"));
        expected.add(new StringBuilder("ELAHW"));
        Assert.assertEquals(expected.toString(), searchedValues.toString());
    }
}
