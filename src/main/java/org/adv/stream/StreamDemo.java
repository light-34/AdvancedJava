package org.adv.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static List<String> startsWith(List<String> list, String letter) {
        return list.stream()
                .filter(element -> element.startsWith(letter)).toList();
    }

    public static <T> List<T> convertArrayToList(T[] array) {
        List<T> list = new ArrayList<>();
        list.addAll(Arrays.asList(array));

        return list;
    }

}
