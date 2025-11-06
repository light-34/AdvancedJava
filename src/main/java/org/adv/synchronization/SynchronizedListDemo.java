package org.adv.synchronization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>()); //This is thread safe
//
//        Thread firstThread = new Thread(() -> {
//            for (int i = 0; i < 30; i++) {
//                list.add("first");
//            }
//        });
//
//        Thread secondThread = new Thread(() -> {
//            for (int i = 0; i < 30; i++) {
//                list.add("second");
//            }
//        });
//
//        firstThread.start();
//        secondThread.start();
//
//        System.out.println(list);

        ThreadDemo first = new ThreadDemo("FirstT", list);
        ThreadDemo second = new ThreadDemo("SecondT", list);
        first.start();
        second.start();
        System.out.println(list);
    }
}
