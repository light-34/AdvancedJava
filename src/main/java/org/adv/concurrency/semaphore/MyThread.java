package org.adv.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread{
    Semaphore semaphore;
    String threadName;
    public MyThread(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        if (this.getName().equals("A")) { // run by thread A
            System.out.println("Starting " + threadName);
            try {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a PERMIT from semaphore.");
                semaphore.acquire();

                System.out.println(threadName + " PERMIT granted.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for (int i = 0; i < 10; i++) {
                    Shared.count--;
                    System.out.println(threadName + ": " + Shared.count);

                    // Now, allowing a context switch -- if possible.
                    // for thread B to execute
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // Release the permit.
            System.out.println(threadName + " released the PERMIT");
            semaphore.release();
        } else { // run by thread B
            System.out.println("Starting " + threadName);
            try {
                System.out.println(threadName + " is waiting for a PERMIT from semaphore.");

                semaphore.acquire();

                System.out.println(threadName + " PERMIT granted.");

                for (int i = 0; i < 10; i++) {
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);
                    Thread.sleep(10);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(threadName + " released the PERMIT");
            semaphore.release();
        }
    }
}
