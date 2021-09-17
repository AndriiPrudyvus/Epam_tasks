package com.epam.rd.java.basic.practice4;

import java.util.*;

public class Part5 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter(System.lineSeparator());
        Locale locale = new Locale("en", "En");
        Locale locale1 = new Locale("ru", "RU");
        ResourceBundle englishResource = ResourceBundle.getBundle("resources_en", locale);
        ResourceBundle rusResources = ResourceBundle.getBundle("resources_ru", locale1);
        String lines;
        while (!(lines = scanner.next()).equals("stop")) {
            String[] line = lines.split(" ");
            if (line[1].equals("en")) {
                System.out.println(englishResource.getString(line[0]));
            }
            if (line[1].equals("ru")) {
                System.out.println(rusResources.getString(line[0]));
            }
        }
        scanner.close();
    }
}
