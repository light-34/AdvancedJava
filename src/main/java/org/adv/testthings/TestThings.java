package org.adv.testthings;

public class TestThings { // Class
    public static void main(String[] args) { // Method

        String txt = "Some XML data with invalid character \u001A here.";

        String cleanTxt = txt.replaceAll("\u001A", "");

        System.out.println(cleanTxt);

    }
}
