package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.parser.ParserSTAXXml;
import com.epam.rd.java.basic.practice7.parser.ParserDOMXml;
import com.epam.rd.java.basic.practice7.parser.ParserSAXXml;
import com.epam.rd.java.basic.practice7.sort.Sort;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.Collections;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Main {
    public static void main(final String[] args) throws IOException {

        ParserDOMXml parserDOMXml = new ParserDOMXml();
        try {
            List<User> users = parserDOMXml.parseInputByDom(args[0]);
            Collections.sort(users, Sort.sortByNameDOM());
            parserDOMXml.writeParseDataIntoXML(users, "output.dom.xml");
        } catch (SAXException | ParserConfigurationException | IOException e) {
        Path pathDom = Paths.get("output.dom.xml");
        Path pathSax = Paths.get("output.sax.xml");
        Path pathStax = Paths.get("output.stax.xml");
            Files.deleteIfExists(pathDom);
            Files.deleteIfExists(pathSax);
            Files.deleteIfExists(pathStax);
            Thread.currentThread().interrupt();
        }

        ParserSAXXml parseSax = new ParserSAXXml();
        try {
            List<User> usersTwo = parseSax.parseInputSax(args[0]);
            Collections.sort(usersTwo, Sort.sortByNameSAX());
            parserDOMXml.writeParseDataIntoXML(usersTwo, "output.sax.xml");
        } catch (ParserConfigurationException | SAXException | IOException e) {
        Path pathDom = Paths.get("output.dom.xml");
        Path pathSax = Paths.get("output.sax.xml");
        Path pathStax = Paths.get("output.stax.xml");
            Files.deleteIfExists(pathDom);
            Files.deleteIfExists(pathSax);
            Files.deleteIfExists(pathStax);
            Thread.currentThread().interrupt();
        }

        ParserSTAXXml parserStaxXml = new ParserSTAXXml();
        try {
            List<User> usersThree = parserStaxXml.parseSTAXUser(args[0]);
            Collections.sort(usersThree, Sort.sortByNameSTAX());
            parserDOMXml.writeParseDataIntoXML(usersThree, "output.stax.xml");
        } catch (FileNotFoundException | XMLStreamException e) {
             Path pathDom = Paths.get("output.dom.xml");
        Path pathSax = Paths.get("output.sax.xml");
        Path pathStax = Paths.get("output.stax.xml");
            Files.deleteIfExists(pathDom);
            Files.deleteIfExists(pathSax);
            Files.deleteIfExists(pathStax);
            Thread.currentThread().interrupt();
        }
    }
}
