package com.fish.design.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * JAVA 1.8
 * 时间处理工具
 */
public class UpgradeDateUtil {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter SIMPLE_DATE_TIMT_FORMATER = DateTimeFormatter.ofPattern(DATETIME_FORMAT);


    public Date parse(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
        LocalDateTime localDateTime = LocalDateTime.parse(value, formatter);
        Date date = new Date();
//        LocalDateTime.


        return null;
    }





//    public DateTimeFormatter getDateFormart() {
//        return new DateTimeFormatter("");
//    }

    private UpgradeDateUtil() {
    }
}
