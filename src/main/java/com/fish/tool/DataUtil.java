package com.fish.tool;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataUtil {
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT);


    public static Date parseDate(String dateString, String pattern) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        try {
            DateTimeFormatter dateTimeFormatter;
            if (StringUtils.isBlank(pattern)) {
                dateTimeFormatter = DEFAULT_FORMATTER;
            } else {
                dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            }
            LocalDateTime localDateTime = LocalDateTime.parse(dateString, dateTimeFormatter);
            return Date.from(Instant.from(localDateTime));
        } catch (Exception e) {

        }
        return null;
    }

    public static Date parseDateSimple(String dateString) {
        return parseDate(dateString, null);
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        try {
            DateTimeFormatter dateTimeFormatter;
            if (StringUtils.isBlank(pattern)) {
                dateTimeFormatter = DEFAULT_FORMATTER;
            } else {
                dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            }
            return dateTimeFormatter.format(Instant.ofEpochMilli(date.getTime()));
        } catch (Exception e) {

        }
        return null;
    }

    public static String formatDateSimple(Date date, String pattern) {
        return formatDate(date, null);
    }

    

    private DataUtil() {
        }
    }
