package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Part1Test {

    private String input;

    @Before
    public void beforeTests() {
        input = Util.getInput("part1.txt");
    }

    @Test
    public void shouldTestConvert1() {

        String expected = "ivanov: ivanov@mail.com\n" +
                "петров: petrov@google.com\n" +
                "obama: obama@google.com\n" +
                "bush: bush@mail.com\n";
        Assert.assertEquals(expected, Part1.convert1(input));
    }

    @Test
    public void shouldTestConvert2() {
        String expected = "Ivanov Ivan (email: ivanov@mail.com)\n" +
                "Петров Петр (email: petrov@google.com)\n" +
                "Obama Barack (email: obama@google.com)\n" +
                "Буш Джордж (email: bush@mail.com)\n";

        Assert.assertEquals(expected, Part1.convert2(input));
    }

    @Test
    public void shouldTestConvert3() {
        String expected = "mail.com ==> ivanov, bush\n" +
                "google.com ==> петров, obama\n";
        Assert.assertEquals(expected, Part1.convert3(input));
    }

    @Test
    public void shouldTestConvert4() {
        String expected = "Login;Name;Email;Password\n" +
                "ivanov;Ivan Ivanov;ivanov@mail.com;1707\n" +
                "петров;Петр Петров;petrov@google.com;9321\n" +
                "obama;Barack Obama;obama@google.com;4623\n" +
                "bush;Джордж Буш;bush@mail.com;7514\n";
        Assert.assertEquals(expected, Part1.convert4(input));
    }
}