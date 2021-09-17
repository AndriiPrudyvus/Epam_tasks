package com.epam.rd.java.basic.practice4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

public class Part1Test {

    private String dataFromFile;

    private static BufferedReader bufferedReader;

    static {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("part1.txt"), "Cp1251"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Before
    public void beforeTest() throws IOException {

        StringBuilder readDataFiles = new StringBuilder();

        String readDataFromFile;

        while ((readDataFromFile = bufferedReader.readLine()) != null) {
            readDataFiles.append(readDataFromFile).append('\n');
        }

        dataFromFile = readDataFiles.toString();
    }

    @Test
    public void parseDataFromTheFileTask1() {

        String expected = "en I was ung i is is\n" +
                "I am rried om enty ghteen ia\n" +
                "РЇ РµРЅРІС‚ С€ РєРµРЅСЏ СЃС‚СЊ РµРЅР°\n" +
                "РЇ РґСЂСѓР¶РµРЅРёР№ С– Сѓ РµРЅРµ С” СѓСЂСѓР¶РёРЅР°\n";

        Assert.assertEquals(expected, Part1.parseDataFromFile(dataFromFile));
    }

    @After
    public void afterTest() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            //Logger imitation
        }
    }
}
