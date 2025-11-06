package org.adv.concurrency.executorpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskMain {

    static final int MAX_T = 3;
    public static void main(String[] args) {
        // creates five tasks
        Runnable a = new Task("task 1");
        Runnable b = new Task("task 2");
        Runnable c = new Task("task 3");
        Runnable d = new Task("task 4");
        Runnable e = new Task("task 5");

        // creates a thread pool with MAX_T no. of
        // threads as the fixed pool size(Step 2)
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        pool.execute(a);
        pool.execute(b);
        pool.execute(c);
        pool.execute(d);
        pool.execute(e);

        // pool shutdown ( Step 4)
        pool.shutdown();

    }
}
