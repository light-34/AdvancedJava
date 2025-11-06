package org.adv.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class HashTableDemo {
    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Orange", "Banana", "Apple", "Melon", "Cherry");
        hashMapMethod(fruits).forEach((key, value) -> System.out.println(value));
        hashSetMethod(fruits).forEach(System.out::print);
    }

    public static Map<Integer, String> hashMapMethod(List<String> data) {
        Map<Integer, String> results = new HashMap<>();
        int i = 0;
        while ( i < data.size()) {
            results.put(i, data.get(i));
            i++;
        }

        return results;
    }

    public static HashSet<String> hashSetMethod(List<String> data) {

        return new HashSet<>(data);
    }
}
