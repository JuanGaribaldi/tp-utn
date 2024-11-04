package com.utn.supergym.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
class DateUtilTest {

    private final LocalDate localDate = LocalDate.of(2024, 01, 02);
    private final LocalTime localTime = LocalTime.of(12, 11, 12);
    private final LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    private final String FECHA_STRING = "2024-01-02 12:11:12";
    private final String EXPECTED_DATE_TIME_STRING = localDate.toString() + " " + localTime.toString();
    private final String EXPECTED_DATE_STRING = localDate.toString();

    @Test
    void parseLocalDateTimeConDatoNoNull() {
        LocalDateTime parsedLocalDateTime = DateUtil.parseLocalDateTime(FECHA_STRING);

        Assertions.assertEquals(localDateTime, parsedLocalDateTime);
    }

    @Test
    void parseLocalDateTimeConDatoNull() {
        Assertions.assertNull(DateUtil.parseLocalDateTime(null));
    }

    @Test
    void toDateTimeStringConDatoNoNull() {
        String dateTimeString = DateUtil.toDateTimeString(localDateTime);

        Assertions.assertEquals(EXPECTED_DATE_TIME_STRING, dateTimeString);
    }

    @Test
    void toDateTimeStringConDatoNull() {
        Assertions.assertNull(DateUtil.toDateTimeString(null));
    }

    @Test
    void toDateStringConDatoNoNull() {
        String dateString = DateUtil.toDateString(localDateTime);

        Assertions.assertEquals(EXPECTED_DATE_STRING, dateString);
    }

    @Test
    void toDateStringConDatoNull() {
        Assertions.assertNull(DateUtil.toDateString(null));
    }
}