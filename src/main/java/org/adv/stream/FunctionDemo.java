package org.adv.stream;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        //Function<T, R> T -> type of input R -> type of return value
        Function<Integer, Double> intToDouble = num -> num * 2.0;

        intToDouble = intToDouble.andThen(num -> num / 3);

        System.out.println(intToDouble.apply(20));

        Function<Integer, Integer> fun1 = i -> i * 4;
        System.out.println(fun1.apply(3));  // 12

        Function<Integer, Integer> fun2 = j -> j + 4;
        System.out.println(fun2.apply(3)); // 7

        Function<String, Integer> fun3 = String::length;
        System.out.println("Length of String : " + fun3.apply("Cezmi"));

        System.out.println("Compose : " + fun2.compose(fun1).apply(5)); //24
        System.out.println("And Then : " + fun2.andThen(fun1).apply(3)); //28

        System.out.println("Identity : " + Function.identity().apply(100));
        System.out.println("Identity : " + Function.identity().apply("Muhsin"));
    }
}
