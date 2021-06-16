/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.netology.pyas;

import java.util.Random;

public class Main {
    private final static int THREADS_COUNT = 4;
    private final static int MIN_TIMEOUT = 2000;
    private final static int MAX_TIMEOUT = 3000;
    private final static int OVERALL_TIMEOUT = 15000;

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Babbling threads");
        Random rng = new Random();

        for (int i = 1; i <= THREADS_COUNT; ++i) {
            String name = "Поток " + String.valueOf(i);
            long timeout = rng.nextInt(MAX_TIMEOUT - MIN_TIMEOUT) + MIN_TIMEOUT;
            new BabblingThread(group, name, timeout).start();
        }

        try {
            Thread.sleep(OVERALL_TIMEOUT);
        } catch (InterruptedException e) {
        }

        group.interrupt();
    }
}
