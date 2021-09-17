package com.epam.rd.java.basic.practice7.parser;

import com.epam.rd.java.basic.practice7.City;
import com.epam.rd.java.basic.practice7.User;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParserSAXXmlTest {

    private ParserSAXXml parserSAXXml = new ParserSAXXml();

    @Test
    public void shouldParseDOMXmlTest() {
        List<User> expectedUsers = Arrays.asList(
                new User("Oleg", 19, City.LVIV, "Epam"),
                new User("Andriy", 50, City.DNIPRO, "Voitovucj"),
                new User("Yura", 130, City.KUIV, "Bahlay"));
        try {
            List<User> users = parserSAXXml.parseInputSax("input.xml");
            Assert.assertEquals(expectedUsers, users);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException | SAXException e) {
            Thread.currentThread().interrupt();
        }
    }
}
