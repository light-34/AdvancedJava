package org.adv.maps;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {
    public static void main(String[] args) {
        Map<Integer, String> hash = new HashMap<>();
        String[] names = {"Cezmi", "Zuhal", "Leyla", "Sibel"};

        for (int i = 0; i < names.length; i++) {
            hash.put(i, names[i]);
        }

        hash.computeIfAbsent(4, k -> "Muhsin");
        hash.computeIfAbsent(5, k -> "Betul"); // computeIfAbsert(K key, Function<> mappingFunction)

        hash.computeIfPresent(5, (key, val) ->  val = "Betul Aktepe"); // computeIfPresent(K key, Function<> reMappingFunction)

        System.out.println(hash.get(0));

        System.out.println(hash.getOrDefault(7, "No Key found")); // getOrDefault(Object key, V defaultValue ) method

        hash.keySet().forEach(System.out::println); //keySet() returns keys
        hash.values().forEach(System.out::println); //values() returns values
    }
}
