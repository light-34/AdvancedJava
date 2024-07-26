package org.adv.formatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class PhoneNumberFormatter {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Please enter phone number");
            String phoneNum = bfr.readLine().trim();
            System.out.println("Formatted number is : " + phoneFormatter(phoneNum));

            //System.out.println(readFromFile("src/main/java/org/adv/formatter/ipsum.txt"));

        } catch (Exception ex) {
            ex.getMessage();
        }

    }

    public static String phoneFormatter(String rawPhoneNumber) {
        StringBuilder result = new StringBuilder();

        if (rawPhoneNumber.length() == 10) {
            result.append(CountryPhoneNumberCodes.CANADA.getCode()).append(" (").append(rawPhoneNumber, 0, 3).append(")-").append(rawPhoneNumber, 3, 6)
                    .append("-").append(rawPhoneNumber, 6, 10);
        }

        return result.toString();
    }

    public static String readFromFile(String path) {
        String result = "";
        try (BufferedReader bfr = new BufferedReader(new FileReader(path))){
            result = bfr.lines().collect(Collectors.joining(System.lineSeparator()));

        } catch (Exception ex) {
            ex.getMessage();
        }
        return result;
    }
}
