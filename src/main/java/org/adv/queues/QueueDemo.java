package org.adv.queues;

import java.util.*;

public class QueueDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);

        System.out.println(deque);

        int out = deque.pop();
        System.out.println("Popped element : " + out);
        System.out.println(deque);

        Queue<String> queue = new PriorityQueue<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");

        System.out.println(queue);

        System.out.println("Popped element : " + queue.poll());

        System.out.println(queue);

    }
}
