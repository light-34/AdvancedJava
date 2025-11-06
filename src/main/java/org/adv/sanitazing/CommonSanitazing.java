package org.adv.sanitazing;

public class CommonSanitazing {
    public static void main(String[] args) {
        System.out.println(sanitize("437-989-3456ABC"));
    }
    public static String sanitize(String input) {
        String output;
        try {
            output = input.replaceAll("[-(){}\\[\\]a-zA-Z]", "");
            if (output.isEmpty()) {
                return "The phone number is empty.";
            } else if (!output.matches("\\d+")) {
                return "The phone number can not contains non-numeric characters.";
            } else if (output.length() > 10) {
                return "The phone number is too long.";
            } else if (output.length() < 10) {
                return "The phone number is too short.";
            } else {
                return String.format("(%s) %s %s", output.substring(0, 3), output.substring(3, 6), output.substring(6, 10));
            }
        } catch (Exception e) {
            return "An exception occurred while sanitizing the input.";
        }
    }
}
