package org.adv.stream;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionDemo {
    public record Person(String name, int age) {
    }

    public static void main(String[] args) {
        //Function<T, R> T -> type of input R -> type of return value
//        Function<Integer, Double> intToDouble = num -> num * 2.0;
//
//        intToDouble = intToDouble.andThen(num -> num / 3);
//
//        System.out.println(intToDouble.apply(20));
//
//        Function<Integer, Integer> fun1 = i -> i * 4;
//        System.out.println(fun1.apply(3));  // 12
//
//        Function<Integer, Integer> fun2 = j -> j + 4;
//        System.out.println(fun2.apply(3)); // 7
//
//        Function<String, Integer> fun3 = String::length;
//        System.out.println("Length of String : " + fun3.apply("Cezmi"));
//
//        System.out.println("Compose : " + fun2.compose(fun1).apply(5)); //24
//        System.out.println("And Then : " + fun2.andThen(fun1).apply(3)); //28
//
//        System.out.println("Identity : " + Function.identity().apply(100));
//        System.out.println("Identity : " + Function.identity().apply("Muhsin"));
//
//        String cez = Collections.nCopies(5, "?").stream().collect(Collectors.joining(",")); //another way
//        String cez = String.join(",", Collections.nCopies(5, "?"));
//        String cez = StringUtils.join(Collections.nCopies(5, "?"), ",");
        //System.out.println(cez);

        Double[] arr2 = {11.0, 12.1, 13.4, 14.3, 15.2, 16.7, 17.3, 18.2, 19.1, 20.6};
        List<Double> doubles = StreamDemo.convertArrayToList(arr2);
        doubles.forEach(System.out::println);

        String[] arr = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        List<String> strings = StreamDemo.convertArrayToList(arr);
        strings.forEach(System.out::println);

        StreamDemo.functionIdentityExample(strings)
                .forEach((key, value) -> System.out.println(key + " : " + value));

        List<Person> persons = List.of(new Person("Muhsin", 23), new Person("Cezmi", 24), new Person("Ali", 25));
        Map<Integer, Person> personMap = persons.stream().collect(Collectors.toMap(Person::age, Function.identity()));
        personMap.forEach((key, value) -> System.out.println(key + " : " + value.name + " : " + value.age));

    }
}
