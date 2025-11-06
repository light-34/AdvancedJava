package org.adv.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException{

        // creating a Semaphore object
        // with number of permits 1
        Semaphore semaphore = new Semaphore(1);

        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        MyThread oneTh = new MyThread(semaphore, "A");
        MyThread twoTh = new MyThread(semaphore, "B");

        // stating threads A and B
        oneTh.start();
        twoTh.start();



        // waiting for threads A and B
        oneTh.join();
        twoTh.join();

        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("count : " + Shared.count);
    }
}
