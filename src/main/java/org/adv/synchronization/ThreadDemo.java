package org.adv.synchronization;

import java.util.List;

public class ThreadDemo extends Thread{
    private String threadName;
    private List<String> list;

    public ThreadDemo(String threadName, List<String> list) {
        this.threadName = threadName;
        this.list = list;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            list.add(threadName);
        }
    }
}
