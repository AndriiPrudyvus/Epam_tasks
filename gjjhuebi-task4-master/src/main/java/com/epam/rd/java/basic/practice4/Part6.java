package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in).useDelimiter(System.lineSeparator());

        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream("part6.txt"), "cp1251"))) {

            StringBuilder result = new StringBuilder();

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                result.append(line).append(" ");
            }

            String data;

            String[] words = result.toString().split("\\s");

            while (!(data = scanner.next()).equals("stop")) {
                String regex = null;
                switch (data.toLowerCase()) {
                    case "latn":
                        regex = "\\b\\w+";
                        break;
                    case "cyrl":
                        regex = "[А-Яа-яҐґіЇїёє]+";
                        break;
                    case "smth":
                        regex = "Incorrect input";
                        System.out.println(data + ": " + "Incorrect input");
                        break;
                    default:
                        regex = null;
                }
                if (!data.equals("smth")) {
                    System.out.print(data + ": ");
                    for (int i = 0; i < words.length; i++) {
                        if (regex != null && Pattern.matches(regex, words[i])) {
                            System.out.print(words[i] + " ");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (IOException e) {
            //Logger Imitate
        }
    }
}
