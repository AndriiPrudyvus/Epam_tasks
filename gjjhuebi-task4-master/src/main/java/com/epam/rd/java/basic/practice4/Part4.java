package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Iterator;

public class Part4 {
    
    private static BufferedReader bufferedReader;

    static {
        try {
            bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream("part4.txt"), "cp1251"));
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            //Logger imitation
        }
    }

    private class ParseIterator implements Iterator<String> {

        private String line = null;

        @Override
        public boolean hasNext() {
            try {
                if ((line = bufferedReader.readLine()) != null) {
                    return true;
                }
            } catch (IOException e) {
                //Logger imitation
                try {
                    bufferedReader.close();
                } catch (IOException e1) {
                    //Logger imitation
                }
            }
            return false;
        }

        @Override
        public String next() {
            if (bufferedReader != null) {
                return line;
            }
            throw new NullPointerException("bufferReader is null");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public Iterator<String> iterator() {
        return new ParseIterator();
    }

    public String parseResult() {

        Iterator<String> iterator = iterator();

        StringBuilder readLinesFromFile = new StringBuilder();

        while (iterator.hasNext()) {
            readLinesFromFile.append(iterator.next()).append(" ");
        }

        readLinesFromFile.setLength(readLinesFromFile.length() - 1);
        String[] arrayLines = readLinesFromFile.toString()
                .replaceAll("[.]", "\n")
                .split("\n");

        StringBuilder resultSentences = new StringBuilder();

        for (int i = 0; i < arrayLines.length; i++) {
            resultSentences.append(arrayLines[i]);
            resultSentences.append(".").append(System.lineSeparator());
        }

        resultSentences.setLength(resultSentences.length() - 1);
        return resultSentences.toString();
    }
    
    public static void main(String[] args) {
        Part4 part4 = new Part4();

        String result = part4.parseResult();

        System.out.print(result);
    }
}
