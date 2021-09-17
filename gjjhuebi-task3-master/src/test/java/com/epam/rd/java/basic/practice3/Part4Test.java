package com.epam.rd.java.basic.practice3;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class Part4Test {

    @Test
    public void shouldConvertPasswordSha_256() throws NoSuchAlgorithmException {
        String data = "ECE016599D34D405DCC88BEE5171906E5E2EBEC15596B5F206357D07130354BE";

        Assert.assertEquals(data, Part4.hash("abvd", "SHA-256"));
    }

    @Test
    public void shouldConvertPasswordSha_384() throws NoSuchAlgorithmException {
        String data = "C0E8FE3E7EBEA62A3F338040C061AAAEDFBB3355B85B0096476841EB9BD1592E0FD1A54F4B1AB946EB1FE6DE07887600";

        Assert.assertEquals(data, Part4.hash("dsdsds", "SHA-384"));
    }

    @Test
    public void shouldConvertPasswordSha_1() throws NoSuchAlgorithmException {
        String data = "F10E2821BBBEA527EA02200352313BC059445190";

        Assert.assertEquals(data, Part4.hash("asd", "SHA-1"));
    }

    @Test
    public void shouldConvertPasswordNb5() throws NoSuchAlgorithmException {
        String data = "36EBA1E1E343279857EA7F69A597324E";

        Assert.assertEquals(data, Part4.hash("fd", "MD5"));
    }

    @Test
    public void shouldConvertPasswordSha_512() throws NoSuchAlgorithmException {
        String data = "49E1CEEA34A674B42CD70B1764A5477227D1FFCD2E63D7DCC123845D4F34C3E284980C72D7" +
                "06FB158889618FFA0D97F13D4025C189E44CE39F44EEE35A20F374";

        Assert.assertEquals(data, Part4.hash("dfd", "SHA-512"));
    }
}
