package org.adv.unittestdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UnitTestDemo {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divide by zero is not allowed");
        }
        return a / b;
    }

    public boolean isEqual(int a, int b) {
        return a == b;
    }

    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public String formatDateTime(LocalDateTime dateTime, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }
}
