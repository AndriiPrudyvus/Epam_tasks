package com.epam.rd.java.basic.practice5;

public class Part1 extends Thread implements Runnable {

   @Override
    public void run() {

        for (int i = 0; i < 4; i++) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    public boolean runPart1WithTwoThreads(Part1 part1) {
        Runnable part2Second = new Part1();

        part1.start();

        try {
            part1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        ((Part1) part2Second).start();

        try {
            ((Thread) part2Second).join();
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }


    public static void main(String[] args) {
        Part1 part1 = new Part1();

        part1.runPart1WithTwoThreads(part1);
    }
}
