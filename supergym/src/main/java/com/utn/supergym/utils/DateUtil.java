package com.utn.supergym.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

    public static LocalDateTime parseLocalDateTime(String fechaPago) {
        return LocalDateTime.parse(fechaPago, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static String toDateTimeString(LocalDateTime fechaPago) {
        return DATE_TIME_FORMATTER.format(fechaPago);
    }

    public static String toDateString(LocalDateTime fechaPago) {
        return DATE_FORMATTER.format(fechaPago);
    }

    public static String toTimeString(LocalDateTime fechaPago) {
        return TIME_FORMATTER.format(fechaPago);
    }

}
