package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part2Test {

    private String input;

    @Before
    public void beforeTests() {
        input = Util.getInput("part2.txt");
    }

    @Test
    public void shouldTestConvert1() {
        String expected = "Min: I, s, m\n" +
                "Max: younger, anybody, assured, changed";
        Assert.assertEquals(expected, Part2.convert(input));
    }
}
