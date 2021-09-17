package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Test;

public class Part2Test {

    @Test
    public void shouldSortElements() {
        int[] numbers = new int[]{123, 1, 44, 22, 33, 14};
        int[] numbersExpected = new int[]{1, 14, 22, 33, 44, 123};
        Assert.assertArrayEquals(numbersExpected, Part2.sortNumbers(numbers));
    }

    @Test
    public void shouldNoSortElements() {
        int[] numbers = new int[]{123, 1, 4, 22, 33, 14};
        int[] numbersExpected = new int[]{1, 14, 22, 33, 44, 123};
        Assert.assertArrayEquals(numbersExpected, Part2.sortNumbers(numbers));
    }
}