package com.utn.supergym.utils;

import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);

    public static LocalDateTime parseLocalDateTime(String fecha) {
        if (StringUtils.isEmpty(fecha)) {
            return null;
        }
        return LocalDateTime.parse(fecha, DATE_TIME_FORMATTER);
    }

    public static String toDateTimeString(LocalDateTime fecha) {
        if (null == fecha) {
            return null;
        }

        return DATE_TIME_FORMATTER.format(fecha);
    }

    public static String toDateString(LocalDateTime fecha) {
        if (null == fecha) {
            return null;
        }

        return DATE_FORMATTER.format(fecha);
    }

    public static String toTimeString(LocalDateTime fecha) {
        if (null == fecha) {
            return null;
        }

        return TIME_FORMATTER.format(fecha);
    }

}
