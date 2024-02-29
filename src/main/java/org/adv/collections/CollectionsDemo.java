package org.adv.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionsDemo {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "First Value");
        map.put(2, "Second Value");
        //map.put(3, null);

        putIfAbsentDemo(map);
        //computeIfAbsentDemo(map);

    }

    public static void putIfAbsentDemo(Map<Integer, String> map) {

        int num = 3;

        map.putIfAbsent(num, null); //It adds an entry for map even if value is null

        System.out.println("***** putIfAbsent *****");
        map.values().forEach(System.out::println);

    }

    public static void computeIfAbsentDemo(Map<Integer, String> map) {

        int num = 3;
        map.computeIfAbsent(num, s -> null); //It does not add an entry for map if value is null

        System.out.println("***** computeIfAbsent *****");
        map.values().forEach(System.out::println);

    }

    public static void addingNnumberOfCopies(List<String> strings, int number) {
        strings = Collections.nCopies(10, "HELLO");

        System.out.println(strings.size());
        strings.stream().forEach(System.out::println);
    }
}
