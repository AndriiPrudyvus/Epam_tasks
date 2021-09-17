package com.epam.rd.java.basic.practice4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part3Test {

    private String result;

    @Before
    public void beforeTest() {
        result = Part3.getInputFromFile("part3.txt");
    }

    @Test
    public void shoutGetInputFromFile() {
        Assert.assertEquals("a bcd 43.43 432 Рё Р» С„РІС‹Р° 89 .98\r\n", result);
    }
}
