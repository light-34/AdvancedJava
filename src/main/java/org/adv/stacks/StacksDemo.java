package org.adv.stacks;

import java.util.Stack;

public class StacksDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);

        int out = stack.pop();
        System.out.println("Popped Element : " + out);
        System.out.println(stack);

    }
}
