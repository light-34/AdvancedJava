package org.adv.concurrency.executorpool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements Runnable{
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                if (i == 0) {
                    LocalDateTime date = LocalDateTime.now();
                    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("H:mm:ss");
                    System.out.println("Initialization Time for task name - " + name + " = " + date.format(dtFormatter));

                } else {
                    LocalDateTime date = LocalDateTime.now();
                    DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("H:mm:ss");
                    System.out.println("Executing Time for task name - " + name + " = " + date.format(dtFormatter));
                }
                Thread.sleep(1000);
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
