package com.fish.algorithm;

public class Main {
    public static void main(String[] args) {
        exclusiveInt();
    }

    private static void exclusiveInt() {
        int a = 1;
        int b = 2;
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 1000000000; i++) {
            a = a + b;
            b = a - b;
            a = a - b;
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        for (int j = 0; j < 1000000000; j ++) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(a);
        System.out.println(b);
    }
}
