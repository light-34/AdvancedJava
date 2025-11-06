package org.adv.algorithms;

import java.util.List;

public class SearchMain {
    public static void main(String[] args) {
        UnorderedSearchAlgorithm<String> searchString = new UnorderedSearchAlgorithm<>();

        List<String> fruits = List.of("apple", "orange", "banana", "melon", "cherry");

        System.out.println(searchString.search(fruits,"coco", fruits.get(0)));
    }
}
