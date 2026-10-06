package org.adv.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeProcess {
    public static void main(String[] args) {
        ProcessTime processTime = new ProcessTime();
        LocalDateTime start = LocalDateTime.parse("2023-03-10T10:00:10", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        LocalDateTime end = LocalDateTime.parse("2023-03-10T10:10:15", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println(processTime.findMinutes(start, end));

    }

}

class ProcessTime {
    public static String findMinutes(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();

        return minutes + ":" + String.format("%02d", seconds);
    }

}
