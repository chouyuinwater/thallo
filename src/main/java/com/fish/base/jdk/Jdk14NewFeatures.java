package com.fish.base.jdk;

import java.util.Calendar;

/**
 * jdk14 新特性测试
 * @author jiangbing
 * @date 2020/6/29 18:46
 * notes and tips:
 */
public class Jdk14NewFeatures {
    public static void main(String[] args) {
        longStringFeatures();
    }

    /**
     * instanceof simple type
     * @param obj
     */
    private static void instanceofFeatures(Object obj) {
        // before
//        Object obj = "程序新视界";
//        Object obj = null;
        if (obj instanceof String) {
            String str = (String) obj;
            System.out.println("关注公众号：" + str);
        }
        // jdk14
        if (obj instanceof String str) {
            System.out.println("关注公众号：" + str);
        }
    }

    /**
     * switch lambda
     * @param day
     */
    private static void switchFeatures(int day) {
        // before
        switch (day) {
            case Calendar.MONDAY:
            case Calendar.TUESDAY:
            case Calendar.WEDNESDAY:
                System.out.println(1);
            case Calendar.THURSDAY:
            case Calendar.FRIDAY:
                System.out.println(4);
            case Calendar.SATURDAY:
            case Calendar.SUNDAY:
                System.out.println(7);
            default:
                System.out.println(-1);
        }

        // after
        switch (day) {
            case Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY  -> System.out.println(1);
            case Calendar.THURSDAY -> System.out.println(4);
            default -> System.out.println(-1);
        }
    }

    /**
     * Preview Features
     * Java 14中记录类型(Record Type)作为预览特性被引入。
     * 记录对象允许使用紧凑的语法来声明类，
     * 和枚举类型一样，记录也是类的一种受限形式。
     */
    private static void recordFeatures() {
        Point point = new Point(1, 3);
        System.out.println(point.x() + " " + point.y());
    }

    private static void longStringFeatures() {
        // before 拼装后输出成一行
        String longStr = "aaaaa" +
                "aaaaaaa" +
                "aaaaaaaaa" +
                "aaaaaaa";
        System.out.println(longStr);
        // after 保持格式原样输出
        String longStr1 = """
                aaaaaa
                    aaaaa
                        aaaaaaa
                        aaaaaaaa
                    aaaaa
                aaaaa
                """;
        System.out.println(longStr1);
    }

}
