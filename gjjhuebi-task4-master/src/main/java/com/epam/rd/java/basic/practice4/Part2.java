package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Part2 {
    
    static int[] sortNumbers(int[] arr) {

        int[] tpmArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tpmArray[i] = arr[i];
        }
        int n = tpmArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tpmArray[j] > tpmArray[j + 1]) {
                    int temp = tpmArray[j];
                    tpmArray[j] = tpmArray[j + 1];
                    tpmArray[j + 1] = temp;
                }
            }
        }
        return tpmArray;
    }

    private static void printFromInputFileAndSortingFile(int[] arr, int[] sortedArray) {
        int n = 0;
        System.out.print("input ==> ");
        for (int i = 0, j = -1; i < (arr.length + sortedArray.length) + 1; i++, j++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + " ");
            } else if (i == arr.length) {
                System.out.print(arr[arr.length - 1]);
            } else if (i == arr.length + 1) {
                System.out.print('\n' + "output ==> ");
            } else if (j > arr.length) {
                System.out.print(sortedArray[n] + " ");
                n++;
            }
        }
        System.out.print(sortedArray[sortedArray.length - 1] + System.lineSeparator());
    }

    private static int[] createRandomNumbers() {
        Random createRandomNumbers = new Random();
        int[] randomsNumbers = new int[10];
        for (int i = 0; i < randomsNumbers.length; i++) {
            int n = createRandomNumbers.nextInt(50);
            randomsNumbers[i] = n;
        }
        return randomsNumbers;
    }

    static void getResultAndPrintToConsole() {
        File filePartTwo = new File("part2.txt");
        File filePartTwoSorted = new File("part2_sorted.txt");

        boolean createPartTwo = false;
        boolean createPartTwoSorted = false;


        try {
            createPartTwo = filePartTwo.createNewFile();
            createPartTwoSorted = filePartTwoSorted.createNewFile();
        } catch (IOException e) {
            //Logger imitation
        }


        try (FileInputStream inputFilePartTwo = new FileInputStream(filePartTwo);
             FileOutputStream outPutFilePartTwoSorted = new FileOutputStream(filePartTwoSorted);
             FileOutputStream outPutFilePartTwo = new FileOutputStream(filePartTwo)) {

            int[] randomsNumbers = createRandomNumbers();

            for (int i = 0; i < randomsNumbers.length; i++) {
                if (i < randomsNumbers.length - 1) {
                    outPutFilePartTwo.write(Integer.toString(randomsNumbers[i]).concat(" ").getBytes());
                }
            }
            outPutFilePartTwo.write(Integer.toString(randomsNumbers[randomsNumbers.length - 1]).getBytes());

            Scanner scanner = new Scanner(inputFilePartTwo);

            int[] arr = new int[10];
            int l = 0;
            while (scanner.hasNext()) {
                arr[l] = scanner.nextByte();
                l++;
            }

            scanner.close();
            final int[] sortedArray = sortNumbers(arr);

            int z = 0;
            while (z < sortedArray.length) {
                if (z < sortedArray.length - 1) {
                    outPutFilePartTwoSorted.write(Integer.toString(sortedArray[z]).concat(" ").getBytes());
                }
                z++;
            }
            outPutFilePartTwoSorted.write(Integer.toString(sortedArray[sortedArray.length - 1]).getBytes());

            printFromInputFileAndSortingFile(arr, sortedArray);


            if (createPartTwo) {
                filePartTwo.deleteOnExit();
            }
            if (createPartTwoSorted) {
                filePartTwoSorted.deleteOnExit();
            }

        } catch (IOException e) {
            //Logger imitation
        }
    }

    public static void main(String[] args) {
        getResultAndPrintToConsole();
    }

}
