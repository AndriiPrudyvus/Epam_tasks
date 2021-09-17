package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

public class Part5Test {

    @Test
    public void shouldConvertFromDecimalToRoman() {
        Assert.assertEquals("LVII", Part5.decimal2Roman(57));
    }

    @Test
    public void shouldConvertFromRomanToDecimal() {
        Assert.assertEquals(57, Part5.roman2Decimal("LVII"));
    }
}
