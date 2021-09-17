package com.epam.rd.java.basic.practice5;

public class Part3 {

    private int counter;

    private int counter2;
    
    private int numberOfIterations;

    private int numberOfThreads;

    private Thread[] threads;

    public Part3(int numberOfIterations, int numberOfThreads) {
        this.threads = new Thread[numberOfThreads];
        this.numberOfIterations = numberOfIterations;
        this.numberOfThreads = numberOfThreads;
    }
    
    private class NoSynchronize extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < numberOfIterations; i++) {
                System.out.println(counter == counter2);
                counter++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                counter2++;
            }
        }
    }
    
    private class SynchronizeThread extends Thread {
        @Override
        public void run() {
            synchronized (Part3.class) {
                for (int i = 0; i < numberOfIterations; i++) {
                    System.out.println(counter == counter2);
                    counter++;
                    try {
                        Thread.sleep(100);
                        counter2++;
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
    

    public void compare() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new NoSynchronize();
            threads[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
                threads[i].interrupt();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void compareSync() {
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new SynchronizeThread();
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            try {
                threads[i].join();
                threads[i].interrupt();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public static void main(final String[] args) {
        Part3 part3 = new Part3(3, 3);
        part3.compare();
        part3.compareSync();
    }
}
