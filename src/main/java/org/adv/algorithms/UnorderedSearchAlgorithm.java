package org.adv.algorithms;

import java.util.Arrays;
import java.util.List;

public class UnorderedSearchAlgorithm <T> {

    private T finalResult;

    public T search(List<T> data, T value, T result) {
        for (T datum : data) {
            if (datum == value)
                return datum;
        }
        return result;
    }
}
