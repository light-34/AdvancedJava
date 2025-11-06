package org.adv.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> System.out.println("This is first Executors"));
        executorService.submit(new RunnableDemo());
        executorService.shutdown();

    }
}
