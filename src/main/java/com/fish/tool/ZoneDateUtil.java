package com.fish.tool;

import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * 处理时区和时间
 *
 * @author jiangbing
 * 2018/9/20
 */
public class ZoneDateUtil {

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String ZONE_ID = "UTC+07";

    public static final String ZONE_CN = "UTC+08";

    public static Instant toInstant(Date date) {
        return Instant.ofEpochMilli(date.getTime());
    }

    public static Date toDate(Instant instant) {
        return new Date(instant.toEpochMilli());
    }



    /**
     * 根据时区将时间转换为指定格式的字符串
     * @param date   指定时间
     * @param zoneId 指定时区
     * @param format 指定格式
     * @return 1911-11-11 11:11:11
     */
    public static String format(Date date, ZoneId zoneId, String format){
        try {
            if (date == null) {
                return null;
            }
            if (StringUtils.isBlank(format)) {
                format = DATETIME_FORMAT;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            if (zoneId == null) {
                return formatter.format(Instant.ofEpochMilli(date.getTime()));
            }
            return formatter.format(LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(date.getTime()), zoneId));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 根据时区将时间转换为指定格式的字符串
     * @param date   指定时间
     * @param zoneId 指定时区
     * @return 1911-11-11 11:11:11
     */
    public static String format(Instant date, ZoneId zoneId){
        try {
            if (date == null) {
                return null;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
            if (zoneId == null) {
                return formatter.format(date);
            }
            return formatter.format(LocalDateTime.ofInstant(date, zoneId));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将当前时区的时间转换为目标时区的时间
     * @param date 当前时区时间
     * @param zoneId 当前时区
     * @param targetZoneId 目标时区
     * @return 目标时区的时间
     */
    public static Date parse(String date, ZoneId zoneId, ZoneId targetZoneId){
        try {
            if (date == null || zoneId == null || targetZoneId == null) {

            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
            LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
            zonedDateTime = zonedDateTime.withZoneSameInstant(targetZoneId);
            return Date.from(zonedDateTime.toInstant());

        } catch (DateTimeParseException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    private ZoneDateUtil() {
    }
}
