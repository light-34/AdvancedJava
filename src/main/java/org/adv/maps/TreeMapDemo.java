package org.adv.maps;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {

        treeMapDemo(List.of("Cezmi","Muhsin", "Stepan","Lila", "Zila", "Zuru", "Duru","Ali"));

    }

    public static void treeMapDemo(List<String> names) {
        Map<Integer, String> treeMap = new TreeMap<>();

        int i = 0;
        for (String name: names) {
            treeMap.put(i, name);
            i++;
        }

        treeMap.values().stream().sorted().forEach(System.out::println);

    }
}
