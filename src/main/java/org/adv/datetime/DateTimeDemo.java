package org.adv.datetime;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.util.List;

import static org.adv.datetime.DateTimeDemoNew.*;

public class DateTimeDemo {

    //Time zone id list : https://docs.oracle.com/middleware/1221/wcs/tag-ref/MISC/TimeZones.html
    public static void main(String[] args) {
        /*DateTime dateTime = new DateTime(); //joda-time package
        System.out.println("Local Date Time : " + LocalDateTime.now()); //LocalDateTime
        System.out.println("LocalDate : " + LocalDate.now()); //LocalDate
        System.out.println("LocalTime " + LocalTime.now()); //Local Time
        System.out.println(dateTime.getMillis());

        LocalDateTime currentDate = LocalDateTime.now(DateTimeZone.forID("Asia/Tokyo")); //DateTimeZone.getDefault()
        System.out.println("Default : " + currentDate);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy/MM/dd - HH:mm:ss");
//        DateTime dt = DateTime.parse("2023-11-17 24:51.016", formatter);
//        System.out.println("After Formatter : " + dt);

        //Instant
        Instant instant = Instant.now();
        int year = instant.get(DateTimeFieldType.year());
        int month = instant.get(DateTimeFieldType.monthOfYear());
        int day = instant.get(DateTimeFieldType.dayOfMonth());

        String time = year + "/" + month + "/" + day;
        System.out.println(time);

        System.out.println("Converted Instant : " + instant.toDateTime());


        System.out.println(DateTimeDemoNew.millisecondsToFormattedDateTime("1731429929"));
        System.out.println(DateTimeDemoNew.millisecondsToFormattedDateTime("1731433529"));*/

//        System.out.println("First : " + DateTimeDemoNew.convertFormattedDateTimeToUnix("2024/11/15 00:00:22", "yyyy/MM/dd HH:mm:ss"));
//        System.out.println("Second : " + DateTimeDemoNew.convertFormattedDateTimeToUnix("2024-11-15", "yyyy-MM-dd"));
        //System.out.println("Third : " + DateTimeDemoNew.convertFormattedDateTimeToUnix("2024-11-15 00:01", "yyyy-MM-dd HH:mm"));
//        List<String> dateRange = DateTimeDemoNew.generateDateRange("20240101", "20250613", 15);
//        dateRange.forEach(System.out::println);
//
//        DateTimeDemoNew.buildDuration();
        System.out.println(getCurrentDateTime());

        LocalDateTime now = LocalDateTime.now().minusDays(30);

        System.out.println(getEpochSeconds(now));

        System.out.println(convertUnixTimestampToFormattedDateTime("1747056129"));




    }
}
