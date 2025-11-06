package org.adv.specialcharactersql;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunSpecialCharacters {
    private static final String SPECIAL_CHAR = "([\\\\'\"\b\n\r\t0Z%_])";
    private static final String SPECIAL_CHARACTERS = "([\\\\'\"\b\n\r\t\0%_])";
    private static final String APP = "'";

    public static String escapeSpecialCharacters(String input) {
        Pattern pattern = Pattern.compile(APP);
        Matcher matcher = pattern.matcher(input);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String match = matcher.group();
            matcher.appendReplacement(sb, "\\" + match);
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String escapeSpecialCharacters2(String input) {

        return input.replaceAll(APP, "\\\\'");
    }

    public static List<String> excapeSpacialCharactersList(List<String> inputs) {
        return  inputs.stream().map(input ->
                input.replaceAll(SPECIAL_CHAR, "\\\\$1")
                ).toList();
    }

    public static void main(String[] args) {
        String input = "This is ' a test ' string with ' special characters: '";
        String escapedInput = escapeSpecialCharacters2(input);
        List<String> inputs = List.of("Hello_ ' me", "Hello ' %you", "O'Hare", "O'Share", "slas \\ hs");
        excapeSpacialCharactersList(inputs).forEach(System.out::println);

        System.out.println("Original: " + input);
        System.out.println("Escaped: " + escapedInput);
    }
}
