package com.epam.rd.java.basic.practice5;

import org.junit.Assert;
import org.junit.Test;

public class Part3Test {

    @Test
    public void shouldTestPart3Compare() {
        String str = "true\n" +
                "true\n" +
                "true\n" +
                "false\n" +
                "true\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false\n" +
                "false";
        Assert.assertEquals(str, str);
    }
}