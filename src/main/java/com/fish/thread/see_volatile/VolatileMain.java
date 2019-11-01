package com.fish.thread.see_volatile;

import com.fish.thread.bean.UserInfo;
import java.util.Random;

public class VolatileMain {
    public static void main(String[] args) {
        test_3();
//        test_2();
//        test_1();
    }

    private static void test_1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("a");
        System.out.println("begin main " + Thread.currentThread().getName() + " " +  userInfo.toString());
        VolatileTest_1 volatileTest1 = new VolatileTest_1();
        volatileTest1.setUserInfo(userInfo);
        for (int i = 0; i < 10 ; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("thread " + Thread.currentThread().getName() + " begin");

                UserInfo userInfo1 = volatileTest1.getUserInfo();
                System.out.println("thread "  + Thread.currentThread().getName() + " " + userInfo1.toString());
                userInfo1.setName("b");
                userInfo1.setId(new Random().nextLong());
                System.out.println("thread "  + Thread.currentThread().getName() + " " + userInfo1.toString());
            });
            thread.start();
        }

        try {
            System.out.println("sleep start");
            Thread.sleep(10000);
            System.out.println("sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        userInfo = volatileTest1.getUserInfo();
        System.out.println("end main " +  userInfo.toString());
    }

    private static void test_2() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1L);
        userInfo.setName("a");

        VolatileRunnable volatileRunnable = new VolatileRunnable(userInfo);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(volatileRunnable);
            threads[i] = thread;
        }
        for (int i = 0; i < 10 ; i++) {
            threads[i].start();
        }

        try {
            System.out.println("sleep start");
            Thread.sleep(10000);
            System.out.println("sleep end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end main " +  userInfo.toString());
    }

    private static void test_3() {
        UserInfo userInfo = new UserInfo();
        userInfo.setSex((byte)2);
        VolatileFlag volatileFlag = new VolatileFlag();
        volatileFlag.setUserInfo(userInfo);
        VolatileSetFlag volatileSetFlag = new VolatileSetFlag();
        volatileSetFlag.setUserInfo(userInfo);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(volatileFlag);
            threads[i] = thread;
        }
        for (int i = 0; i < 10 ; i++) {
            threads[i].start();
        }
//        Thread a = new Thread(volatileFlag);
//        a.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread b = new Thread(volatileSetFlag);
        b.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String msg = volatileFlag.getUserInfo().toString();
//        System.out.println(msg);
    }
}


