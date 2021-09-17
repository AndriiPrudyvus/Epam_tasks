package com.epam.rd.java.basic.practice5;

import org.junit.Assert;
import org.junit.Test;

public class Part1Test {

    private Part1 part1 = new Part1();

    @Test
    public void shouldTestPart1() {
        Assert.assertTrue(String.valueOf(Boolean.TRUE), part1.runPart1WithTwoThreads(part1));
    }
}
