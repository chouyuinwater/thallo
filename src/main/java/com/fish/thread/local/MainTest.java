package com.fish.thread.local;

public class MainTest {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new InheritableThreadLocal<>();
        stringThreadLocal.set("你好");
        System.out.println(stringThreadLocal.get());
    }
}
