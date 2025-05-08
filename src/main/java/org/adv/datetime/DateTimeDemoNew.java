package org.adv.datetime;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DateTimeDemoNew {
    private static final Logger LOG = LogManager.getLogger(DateTimeDemoNew.class.getName());
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE_DATE = "yyyyMMdd";
    public static final String SIMPLE_TIME = "HH:mm:ss";
    public static final String DASHED_DATE = "yyyy-MM-dd";
    public static final ZoneId ZONE = ZoneId.of("America/New_York");

    /**
     * convert UTC datetime to db2 datetime
     * @param utcTimestamp UTC unix timestamp in seconds i.e. 1433346982.120011
     * @return string format of eastern Timestamp of db2 datetime
     */
    public static String millisecondsToFormattedDateTime(String utcTimestamp) {
        String db2Time = "";

        if (StringUtils.isBlank(utcTimestamp)) {
            return db2Time;
        }
        try {
            String[] utcTimestampParts = StringUtils.split(utcTimestamp, ".");
            Instant instant = Instant.ofEpochSecond(Long.parseLong(utcTimestampParts[0]));

            String microseconds = (utcTimestampParts.length > 1) ? utcTimestampParts[1] : "000000";

            db2Time = DateTimeFormatter.ofPattern(DATETIME_FORMAT).withZone(ZONE).format(instant) + "." + microseconds;

        } catch (Exception ex) {
            LOG.warn("FAILED_TO_CONVERT_DATE {}", utcTimestamp);
        }

        return db2Time;
    }

    public static String unixToDatabase(String timestamp) {
        String convertedTimestamp = "";

        if (StringUtils.isBlank(timestamp)) {
            return convertedTimestamp;
        }

        try {
            String[] timestampParts = StringUtils.split(timestamp, ".");
            Instant instant = Instant.ofEpochSecond(Long.parseLong(timestampParts[0]));
            String microSeconds = (timestampParts.length > 1) ? timestampParts[1] : "000000";
            convertedTimestamp = DateTimeFormatter.ofPattern(DATETIME_FORMAT).withZone(ZoneId.systemDefault()).format(instant) + "." + microSeconds;
        } catch (Exception e) {
            LOG.warn("Failed to convert timestamp. {} ", timestamp);
        }

        return convertedTimestamp;
    }

    public static String convertFormattedDateTimeToUnix(String datetime, String pattern) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            LocalDateTime localDateTime;
            LocalDate localDate;

            if (!pattern.contains("H") && !pattern.contains("m") && !pattern.contains("s")) {
                localDate = LocalDate.parse(datetime, dateTimeFormatter);
                return String.valueOf(localDate.atStartOfDay().atZone(ZONE).toEpochSecond());
            } else {
                localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
                return String.valueOf(localDateTime.atZone(ZONE).toEpochSecond());
            }

        } catch (DateTimeParseException e) {
            LOG.atDebug().log("Failed to parse date {}", datetime);
        }
        return "";
    }

    /**
     * This method is used to generate date ranges between startDate and endDate
     * @param startDate starting date in format of yyyyMMdd
     * @param endDate ending date in format of yyyyMMdd
     * @param numberOfDays number of dates to be added
     * @return returns a list of date range
     */

    public static List<String> generateDateRange(String startDate, String endDate, int numberOfDays) {
        List<String> dateRanges = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SIMPLE_DATE);
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        int daysBetween = (int) ChronoUnit.DAYS.between(start, end);

        if (daysBetween > numberOfDays) {
            LocalDate localDateRange;
            while (daysBetween > 0) {
                int days = Math.min(numberOfDays, daysBetween);
                localDateRange = start.plusDays(days);
                start = localDateRange;
                dateRanges.add(formatter.format(localDateRange));
                daysBetween -= numberOfDays;
            }
        } else {
            dateRanges.add(formatter.format(end));
        }

        return dateRanges;
    }
}
