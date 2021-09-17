package com.epam.rd.java.basic.practice5;

public class Spam {

    private Thread[] threads;

    public Spam(final String[] messages, final int[] delays) {
        if (messages.length < 2 || messages.length != delays.length) {
            System.out.println("Wrong number of arguments.");
        }

        threads = new Thread[messages.length];

        for (int i = 0; i < messages.length; i++) {
            final String message = messages[i];
            final int timeout = delays[i];
            threads[i] = new Worker(message, timeout);
        }
    }

    public static void main(final String[] args) {
        String[] messages = new String[]{"@@@", "bbbbbbb", "spam123", "spam-123"};
        int[] times = new int[]{77, 112, 213, 333};

        final Spam spam = new Spam(messages, times);
        spam.start();
        String response;
        spam.stop();
    }

    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public void stop() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private static class Worker extends Thread {
        private String message;
        private int timeout;
        private boolean interrupted;

        public Worker(String message, int timeout) {
            this.message = message;
            this.timeout = timeout;
        }

        @Override
        public void interrupt() {
            interrupted = true;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(message);

                try {
                    if (interrupted) {
                        return;
                    }

                    sleep(timeout);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
