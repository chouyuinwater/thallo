package com.fish.thread.base;

public class SavePrivateValue {

    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread thread_1 = new Thread(() -> {
            stringThreadLocal.set("thread_1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stringThreadLocal.get());
        });
        thread_1.start();

        Thread thread_2 = new Thread(() -> {
            stringThreadLocal.set("thread_2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stringThreadLocal.get());
        });
        thread_2.start();


        stringThreadLocal.set("main");
        System.out.println(stringThreadLocal.get());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
