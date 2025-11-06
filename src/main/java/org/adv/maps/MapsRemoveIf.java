package org.adv.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapsRemoveIf {
    public static void main(String[] args) {
        mapDataProcess();
    }


    public static void mapDataProcess() {

        Map<Integer, String> dataMap = new HashMap<>();
        dataMap.put(1, "iPhone");
        dataMap.put(2, "Samsung");
        dataMap.put(3,"Google");
        dataMap.put(4, "LG");
        dataMap.put(5, "Huawei");

        dataMap.values().removeIf("Huawei"::equals);

        Map<Integer, String> newDataMap = new HashMap<>(dataMap);

        System.out.println(newDataMap);

    }


}
