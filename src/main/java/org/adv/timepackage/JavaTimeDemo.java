package org.adv.timepackage;

import org.apache.commons.compress.harmony.pack200.Segment;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class JavaTimeDemo {
    private static final ZoneId zoneId = ZoneId.of("Asia/Kolkata"); //  America/New_York
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FORMAT_MILLISECONDS = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String DATETIME_FORMAT_EXP = "MM/dd/yy hh:mm:ss a";
    public static final String DATE_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT_EXPORT = "MM/dd/yy";
    public static final String DATE_DISPLAY_FORMAT = "EEE MMM d, ''yy";// Tue Oct 27, '15
    public static final String DATE_EMAIL_PATTERN  = "M/d/yy, H:mm:ss.SSS z";
    public static final String DATE_PICTURE_HTML_FORMAT = "M/d/yyyy";
    public static final String DATE_PICTURE_FOOTER_FORMAT = "M/d/yy";
    public static final String DATE_PICTURE_LAYOUT_FORMAT = "MM/dd/yyyy HH:mm:ss zzz";
    private static final ZoneId ZONE_ID = ZoneId.of("America/New_York");
    public static final String DATE_EMAIL_HTML = "EEE MMM d, yyyy";
    public static final String SIMPLE_FORMAT = "yyyyMMdd";
    public static final String DISPLAY_FORMAT = "EEEE, MMMM d, yyyy";

    public static final String DATE_DASHED_FORMAT = "yyyy-MM-dd";
    private static final String FAILED_TO_PARSE_DATE = "Failed to parse date: {} ";
    private static final Logger LOG = LogManager.getLogger(JavaTimeDemo.class.getName());

    public static void main(String[] args) {
       /* ZonedDateTime zdt = ZonedDateTime.now(ZONE_ID);
        ZonedDateTime zdt2 = ZonedDateTime.parse("2023-06-06 00:00:00.000000", DateTimeFormatter.ofPattern(DATETIME_FORMAT_MILLISECONDS).withZone(ZONE_ID));
        if (zdt.compareTo(zdt2) > 0) {
            System.out.println("Hello " + zdt.toInstant().toEpochMilli());
        }*/

        List<String> values = List.of("Ali", "John");

        System.out.println(values.contains("Ali") ? "Yes" : "No");

        //System.out.println(convertTimestampToSpecificPattern("20240305", SIMPLE_FORMAT, DISPLAY_FORMAT));


    }

    public static String db2ToUnixTimestamp(String datetime) { //convertDb2DateToTimestamp() db2ToTimestamp()
        long epochSeconds = 0L;
        String date = StringUtils.substringBefore(datetime, ".");

        if (StringUtils.isNotBlank(date)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT).withZone(ZONE_ID);

            try {

                Instant instant = ZonedDateTime.parse(datetime, dateTimeFormatter).toInstant();

                epochSeconds = instant.getEpochSecond();
            } catch (DateTimeParseException e) {
                LOG.atDebug().log(FAILED_TO_PARSE_DATE, datetime);
            }
        }

        return String.valueOf(epochSeconds);
    }

    public static Boolean validateDateTime(String value, String format) {
        try {
            DateTimeFormatter.ofPattern(format).parse(value);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    }

    public static String convertTimestampToSpecificPattern(String timestamp, String existingPattern, String convertingPattern) {
        String convertedTimestamp;
        try {

            DateTimeFormatter existingTimeFormatter = DateTimeFormatter.ofPattern(existingPattern);
            DateTimeFormatter convertingTimeFormatter = DateTimeFormatter.ofPattern(convertingPattern).withZone(ZONE_ID);
            convertedTimestamp =  convertingTimeFormatter.format(existingTimeFormatter.parse(timestamp));


        } catch (DateTimeParseException ex) {
            System.out.println(ex.getMessage());
            return  timestamp;
        }

        return convertedTimestamp;
    }

    public static LocalDate getCurrentLocalDate() {
        return getCurrentZonedTime().toLocalDate();
    }

    public static String getFormatDate(String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return getCurrentZonedTime().format(dateTimeFormatter);
    }

    public static ZonedDateTime getCurrentZonedTime() {
        return ZonedDateTime.now(ZONE_ID);
    }

    public static LocalDateTime getLocalDateTime() {
        return getCurrentZonedTime().toLocalDateTime();
    }

    public static String formatDateTime(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return getCurrentZonedTime().format(formatter);
    }

    public static ZonedDateTime parseDateTime(String date) {
        return ZonedDateTime.parse(date);
    }

    public static String db2ToTimestamp(String datetime) {
        long epochSeconds = 0L;
        String date = StringUtils.substringBefore(datetime, ".");

        if (StringUtils.isNotBlank(datetime)) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT).withZone(ZONE_ID);

            Instant instant = ZonedDateTime.parse(date, dateTimeFormatter).toInstant();

            epochSeconds = instant.getEpochSecond();
        }

        return String.valueOf(epochSeconds);
    }

    public static String convertTimestampToDate(String timestamp, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);

        ZonedDateTime date = Instant.ofEpochSecond(Long.parseLong(timestamp)).atZone(ZONE_ID);

        return dateTimeFormatter.format(date);
    }
}
