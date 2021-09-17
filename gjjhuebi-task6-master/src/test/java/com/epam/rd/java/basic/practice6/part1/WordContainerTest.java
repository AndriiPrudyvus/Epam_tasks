package com.epam.rd.java.basic.practice6.part1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class WordContainerTest {
    
    private WordContainer wordContainer;

    private List<String> words;

    @Before
    public void beforeTest() {
        wordContainer = new WordContainer();
        words = new ArrayList<>();
    }


    @Test
    public void shouldParseLine() {
        words = new ArrayList<>();
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("stop");
        words.add("A");
        words.add("stop");
        Assert.assertEquals(words, wordContainer.parseLines("A B C A B C A B C stop A stop"));
    }


    @Test
    public void shouldAddWordsToTreeAndReceiveEqualsContentAndCountThem() {
        words = new ArrayList<>();
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("stop");
        words.add("A");
        words.add("stop");

        NavigableSet<Word> excepted = new TreeSet<>();
        excepted.add(new Word("A"));
        excepted.add(new Word("B"));
        excepted.add(new Word("C"));

        Assert.assertEquals(excepted, wordContainer.addWordsToTree(words));
    }


    @Test
    public void shouldAddWordsToTreeAndReceiveOneWordWithCount() {
        words = new ArrayList<>();
        words.add("A");
        words.add("stop");
        words.add("A");
        words.add("stop");
        NavigableSet<Word> excepted = new TreeSet<>();
        excepted.add(new Word("A"));
        Assert.assertEquals(excepted, wordContainer.addWordsToTree(words));
    }


    @Test
    public void shouldAddWordsToTreeAndReceiveOneDifferentFrequencyFromBiggerToLower() {
        words = new ArrayList<>();
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("A");
        words.add("C");
        words.add("C");
        words.add("stop");
        words.add("A");
        words.add("stop");

        NavigableSet<Word> excepted = new TreeSet<>();
        excepted.add(new Word("A"));
        excepted.add(new Word("B"));
        excepted.add(new Word("C"));

        Assert.assertEquals(excepted, wordContainer.addWordsToTree(words));
    }


    @Test
    public void shouldAddWordsToTreeAndReceiveDifferentFrequency() {
        words = new ArrayList<>();
        words.add("Hello");
        words.add("Hello");
        words.add("Hello");
        words.add("Time");
        words.add("Time");
        words.add("to");
        words.add("stop");
        words.add("Hello");
        words.add("stop");

        NavigableSet<Word> excepted = new TreeSet<>();
        excepted.add(new Word("Hello"));
        excepted.add(new Word("Time"));
        excepted.add(new Word("to"));

        Assert.assertEquals(excepted, wordContainer.addWordsToTree(words));
    }
}
