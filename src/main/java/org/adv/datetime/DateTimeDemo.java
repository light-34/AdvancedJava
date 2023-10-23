package org.adv.datetime;

import org.joda.time.DateTime;

public class DateTimeDemo {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime(); //joda-time package
        System.out.println(dateTime.getMillis());
    }
}
