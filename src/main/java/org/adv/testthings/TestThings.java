package org.adv.testthings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestThings { // Class
    public static void main(String[] args) { // Method

        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("field", "field_name");
        filterMap.put("value", "Field Value");

        String filterField = Arrays.stream(((String) filterMap.get("field")).split("_"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));

        System.out.println(filterField);

        int maxAttemtpts = 2;
        int attempt = 0;

        do {
            System.out.println("Attempt " + attempt);
            if (++attempt >= maxAttemtpts) {
                break;
            }

        } while (maxAttemtpts <= 10);



//        String txt = "Some XML data with invalid character \u001A here.";
//
//        String cleanTxt = txt.replaceAll("\u001A", "");
//
//        System.out.println(cleanTxt);

    }
}
