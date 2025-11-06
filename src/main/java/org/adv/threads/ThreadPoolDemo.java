package org.adv.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //or creates a thread pool that reuses threads or creates new ones as needed
        //ExecutorService executorService = Executors.newCachedThreadPool();

        //or creates a thread pool with only one thread.
        //ExecutorService executorService = Executors.newFixedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println("Task " + Thread.currentThread().getName() + " is running.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks finished.");
    }
}
