package com.epam.rd.java.basic.practice7.parser;

import com.epam.rd.java.basic.practice7.City;
import com.epam.rd.java.basic.practice7.User;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParserSTAXXml {

    private List<User> users;

    public ParserSTAXXml() {
        this.users = new ArrayList<>();
    }

    public List<User> parseSTAXUser(String input)
            throws FileNotFoundException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(input));
        User user = null;
        while (eventReader.hasNext()) {
            XMLEvent xmlEvent = eventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                StartElement startElement = xmlEvent.asStartElement();
                if ("User".equalsIgnoreCase(startElement.getName().getLocalPart())) {
                    user = new User();
                }
                switch (startElement.getName().getLocalPart()) {
                    case "Name":
                        Characters nameDataEvent = (Characters) eventReader.nextEvent();
                        user.setUserName(nameDataEvent.getData());
                        break;
                    case "Age":
                        Characters ageDataEvent = (Characters) eventReader.nextEvent();
                        user.setAge(Integer.valueOf(ageDataEvent.getData()));
                        break;
                    case "City":
                        Characters cityDataEvent = (Characters) eventReader.nextEvent();
                        user.setCity(City.valueOf(cityDataEvent.getData()));
                        break;
                    case "Surname":
                        Characters surNameDataEvent = (Characters) eventReader.nextEvent();
                        user.setSurName(surNameDataEvent.getData());
                        break;
                    default:
                        break;
                }
            }
            if (xmlEvent.isEndElement()) {
                EndElement endElement = xmlEvent.asEndElement();
                if ("User".equalsIgnoreCase(endElement.getName().getLocalPart())) {
                    users.add(user);
                }
            }
        }
        return users;
    }
}
