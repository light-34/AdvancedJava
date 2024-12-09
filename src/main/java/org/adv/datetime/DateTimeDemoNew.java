package org.adv.datetime;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeDemoNew {
    private static final Logger LOG = LogManager.getLogger(DateTimeDemoNew.class.getName());
    public static final String DB2_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final ZoneId ET_ZONE = ZoneId.of("America/New_York");

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

            db2Time = DateTimeFormatter.ofPattern(DB2_DATETIME_FORMAT).withZone(ET_ZONE).format(instant) + "." + microseconds;

        } catch (Exception ex) {
            LOG.warn("FAILED_TO_CONVERT_DATE {}", utcTimestamp);
        }

        return db2Time;
    }

    public static String unixTimestampToDb2Old(String timestamp) {
        String convertedTimestamp = "";

        if (StringUtils.isBlank(timestamp)) {
            return convertedTimestamp;
        }

        try {
            String[] timestampParts = StringUtils.split(timestamp, ".");
            Instant instant = Instant.ofEpochSecond(Long.parseLong(timestampParts[0]));
            String microSeconds = (timestampParts.length > 1) ? timestampParts[1] : "000000";
            convertedTimestamp = DateTimeFormatter.ofPattern(DB2_DATETIME_FORMAT).withZone(ZoneId.systemDefault()).format(instant) + "." + microSeconds;
        } catch (Exception e) {
            LOG.warn("Failed to convert timestamp. {} ", timestamp);
        }

        return convertedTimestamp;
    }
}
