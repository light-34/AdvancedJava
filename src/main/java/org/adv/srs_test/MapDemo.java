package org.adv.srs_test;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(1, "Cezmi");
        names.put(2, "Zuhal");
        names.put(3, "Muhsin");
        names.put(4, "Sibel");

        names.forEach((k,v) -> {
            if (v.equals("Cezmi"))
                return;
            System.out.println(v);
        });
    }
}
