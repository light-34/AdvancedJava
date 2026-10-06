package org.adv.functional_interface;

import java.util.ArrayList;
import java.util.List;

public class FunctionalMethods {
    public static <T> List<T> printList(int count, PrintingSupplier<T> factory) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(factory.print());
        }

        return list;
    }
}
