package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Part4 {


    private int[][] numbers;

    private Thread[] threads;

    private int mamValueConcurrent;

    public Part4(int[][] numbers, int countThreads, int mamValueConcurrent) {
        this.numbers = numbers;
        this.threads = new Thread[countThreads];
        this.mamValueConcurrent = mamValueConcurrent;
    }

    private class MyOwnThread extends Thread {
        @Override
        public void run() {
            findMaxConcurrent();
        }

        public void findMaxConcurrent() {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    if (mamValueConcurrent < numbers[i][j]) {
                        mamValueConcurrent = numbers[i][j];
                    }
                }
            }
        }
    }


    public String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            Thread.currentThread().interrupt();
        }
        return sb.toString();
    }

    public int[][] parseDataFromFile(String string) {
        String[] stringNumbers = string.trim().split("\\s+");

        numbers = new int[4][100];

        int l = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                numbers[i][j] = Integer.parseInt(stringNumbers[l]);
                l++;
            }
        }
        return numbers;
    }


    public int findMaxValueWithFourThreads() {
        for (int i = 0; i < 4; i++) {
            threads[i] = new MyOwnThread();
            threads[i].start();
        }

        for (int i = 0; i < 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return mamValueConcurrent;
    }


    public int findMaxValueNonConcurrent() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 100; j++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (mamValueConcurrent < numbers[i][j]) {
                    mamValueConcurrent = numbers[i][j];
                }
            }
        }
        return mamValueConcurrent;
    }
    
    public static void main(final String[] args) {
        Part4 part4 = new Part4(new int[4][100], 4, 0);

        String input = part4.getInput("part4.txt");

        part4.parseDataFromFile(input);

        long start = System.currentTimeMillis();

        System.out.println(part4.findMaxValueWithFourThreads() + "\n");

        long end = System.currentTimeMillis() - start;

        System.out.println(end + "\n");

        long startOne = System.currentTimeMillis();

        System.out.println(part4.findMaxValueNonConcurrent() + "\n");

        long endOne = System.currentTimeMillis() - startOne;

        System.out.println(endOne);
    }
}
