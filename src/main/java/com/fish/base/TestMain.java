package com.fish.base;

public class TestMain {
    public static void main(String[] args) {
//        String test = null;
//        System.out.println(test instanceof String);
//        System.out.println(null instanceof Integer);
//        System.out.println(null instanceof Long);
//
//        List<String> stringArrayList = new ArrayList<>();
//        stringArrayList.add("1");
//        stringArrayList.add("2");
//        stringArrayList.add("3");
//        stringArrayList.add("4");
//        stringArrayList = stringArrayList.subList(0, 2);
//        System.out.println(stringArrayList);

//        instanceTest();
        String a = new String("a");
        String b = "a";
        String c = new String("a");
        String d = c.intern();


        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(c == d);
        System.out.println(b == d);

        Integer aa = new Integer("1");
        Integer bb = new Integer("1");
        int cc = 1;
        System.out.println(aa == bb);
    }

    private static void instanceTest() {
        Byte test = new Byte((byte)1);
        Byte test1 = null;
        Byte test2 = 1;
        Byte test3 = new Byte((byte)1);
        byte test4 = 1;
        System.out.println(test instanceof Byte);
        System.out.println(null instanceof Byte);
        System.out.println(test == test1);
        System.out.println(test1 == test2);
        System.out.println(test2 == test);
        System.out.println(test3 == test);
        System.out.println(test2 == test4);
        System.out.println(test1 == test4);
    }
}
