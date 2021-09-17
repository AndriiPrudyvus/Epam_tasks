package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Part1 {
    
     static String readDataFromFile() {
        StringBuilder readDataFiles = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("part1.txt"), "Cp1251"))) {

            String readDataFromFile;

            while ((readDataFromFile = bufferedReader.readLine()) != null) {
                readDataFiles.append(readDataFromFile).append('\n');
            }
        } catch (Exception e) {
            //Logger imitation
        }
        return readDataFiles.toString();
    }

    static String parseDataFromFile(String dataFromFile) {
        final String[] lines = dataFromFile.replaceAll("-", " ")
                .replaceAll(",", " ")
                .replaceAll("'", " ")
                .replaceAll("\n", " \n ")
                .split(" ");

        StringBuilder makeResult = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length() >= 4) {
                makeResult.append(lines[i].substring(2, lines[i].length()));
                if (!lines[i + 1].equals("\n")) {
                    makeResult.append(" ");
                }
            } else if (lines[i].equals("\n")) {
                makeResult.append("\n");
            } else {
                makeResult.append(lines[i]);
                if (!lines[i + 1].equals("\n")) {
                    makeResult.append(" ");
                }
            }
        }
        makeResult.setLength(makeResult.length());
        return makeResult.toString();
    }

    public static void main(String[] args) {
        String dataFile = String.valueOf(readDataFromFile());

        System.out.print(parseDataFromFile(dataFile));
    }
}
