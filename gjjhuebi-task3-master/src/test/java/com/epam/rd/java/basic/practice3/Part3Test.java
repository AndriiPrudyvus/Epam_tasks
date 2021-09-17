package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part3Test {

    private String input;


    @Before
    public void beforeTests() {
        input = Util.getInput("part3.txt");
    }

    @Test
    public void shouldTestConvert1() {
        String expected = "when I Was Younger\n" +
                "I Never Needed";
        Assert.assertEquals(expected, Part3.convert(input));
    }
}
