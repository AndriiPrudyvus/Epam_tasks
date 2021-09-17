package com.epam.rd.java.basic.practice6.part4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class RangeTest {
    private Range range;

    private Range rangeTwo;

    @Before
    public void beforeTest() {
        range = new Range(3, 10);
        rangeTwo = new Range(3, 10, true);
    }

    @Test
    public void shouldReturnRangeIncreased() {

        String expected = "3 4 5 6 7 8 9 10 ";

        Iterator<Integer> iterator = range.iterator();

        StringBuilder numbers = new StringBuilder();

        while (iterator.hasNext()) {
            numbers.append(iterator.next()).append(" ");
        }
        Assert.assertEquals(expected, numbers.toString());
    }


    @Test
    public void shouldReturnRangeDecreased() {
        String expected = "10 9 8 7 6 5 4 3 ";

        Iterator<Integer> iterator = rangeTwo.iterator();

        StringBuilder numbers = new StringBuilder();

        while (iterator.hasNext()) {
            numbers.append(iterator.next()).append(" ");
        }
        Assert.assertEquals(expected, numbers.toString());
    }
}
