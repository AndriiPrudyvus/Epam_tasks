package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part6Test {

    private String inputData;

    @Before
    public void beforeEachTest() {
        inputData = Util.getInput("part6.txt");
    }

    @Test
    public void shouldMethodConvert() {

        String expected = "This _is _a _test\n" +
                "_And this _is _also _a _test\n" +
                "_And these are _also tests\n" +
                "_test\n" +
                "_Это _тест\n" +
                "_Это _также _тест\n" +
                "И это _также тесты";

        Assert.assertEquals(expected, Part6.convert(inputData));
    }
}