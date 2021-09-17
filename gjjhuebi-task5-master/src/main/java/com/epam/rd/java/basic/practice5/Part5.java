package com.epam.rd.java.basic.practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Part5 implements Callable<Object> {
    
    private static final Object MONITOR = new Object();

    private static final int NUMBER_OF_THREADS = 10;

    private static final int DIGITS = 20;

    private static final String FILE_NAME = "part5.txt";

    private static final String ENCODING = "Cp1251";

    private final RandomAccessFile randomAccessFile;

    private final int pointer;

    private final String characters;

    public Part5(RandomAccessFile randomAccessFile, int pointer, String letterToAdd, int length) {

        this.randomAccessFile = randomAccessFile;

        this.pointer = pointer;

        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < DIGITS; i++) {
            stringBuilder.append(letterToAdd);
        }

        stringBuilder.append(System.lineSeparator());

        characters = stringBuilder.toString();
    }

    @Override
    public Object call() throws Exception {
        synchronized (MONITOR) {
            randomAccessFile.seek(pointer);
            randomAccessFile.write(characters.getBytes(ENCODING));
        }
        return null;
    }
    
    public static String getOutput() {
        StringBuilder result = new StringBuilder();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(FILE_NAME), ENCODING);
            while (scanner.hasNext()) {
                result.append(scanner.next());
                result.append(System.lineSeparator());
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("IOException");
        }
        return result.substring(0, result.length() - System.lineSeparator().length());
    }

    public static void main(final String[] args) {
        try {
            Files.deleteIfExists(new File(FILE_NAME).toPath());
        } catch (IOException e) {
            System.err.print("IOException");
        }
        File file = new File(FILE_NAME);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        try (RandomAccessFile accessFile = new RandomAccessFile(file, "rw")) {
            List<Future<Object>> futureList = new ArrayList<>();
            int position = 0;

            for (int i = 0; i < NUMBER_OF_THREADS; i++) {
                String letterToAdd = String.valueOf(i);
                int charsLength = DIGITS * letterToAdd.length();
                int stringLength = charsLength + System.lineSeparator().length();

                Future<Object> future = executorService.submit(
                        new Part5(accessFile,
                                position,
                                letterToAdd,
                                stringLength));

                futureList.add(future);
                position += stringLength;
            }
            for (Future<Object> f : futureList) {
                f.get();
            }
        } catch (IOException | InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            System.err.print("IOException | ExecutionException");
        } finally {
            executorService.shutdown();
        }
        System.out.println(getOutput());
    }
}
