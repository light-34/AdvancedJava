package org.adv.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {
    public static List<String> startsWith(List<String> list, String letter) {
        return list.stream()
                .filter(element -> element.startsWith(letter)).toList();
    }

    public static <T> List<T> convertArrayToList(T[] array) {

        return new ArrayList<>(Arrays.asList(array));
    }

    public static Map<String, String> functionIdentityExample(List<String> list) {
        //Function.identity() is commonly used when you need a function that performs no transformation—in other words, it just returns what it receives.
        return list.stream().collect(Collectors.toMap(Function.identity(), Function.identity()));
    }

}
