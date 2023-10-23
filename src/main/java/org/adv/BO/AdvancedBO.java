package org.adv.BO;

import java.util.Arrays;
import java.util.List;

public class AdvancedBO {

    public static <T> List<T> convertArrayToList(T[] array) {
        return Arrays.asList(array);
    }

    public static <T extends Number> List<T> convertNumberArrayToList(T[] array) {
        return Arrays.asList(array);
    }


}
