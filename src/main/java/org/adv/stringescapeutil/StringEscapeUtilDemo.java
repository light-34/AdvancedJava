package org.adv.stringescapeutil;


import org.apache.commons.text.StringEscapeUtils;

public class StringEscapeUtilDemo {
    public static void main(String[] args) {
        String text = """
                Here is some "Text" that
                I'd like to be "escaped" for Java. <Hello> \u001a
                I'll try a couple special characters here: "
                """;
        String replace = text.replaceAll("\\x1A", "");

        System.out.println(StringEscapeUtils.escapeJava(replace));
    }
}
