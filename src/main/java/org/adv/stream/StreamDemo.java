package org.adv.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static List<String> startsWith(List<String> list, String letter) {
        return list.stream()
                .filter(element -> element.startsWith(letter)).toList();
    }
}
