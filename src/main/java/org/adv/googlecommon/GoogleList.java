package org.adv.googlecommon;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class GoogleList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3,4,5,6,7,8,9,10));
        List<List<Integer>> sublists = Lists.partition(list, 3);
        sublists.forEach(System.out::println);
    }
}
