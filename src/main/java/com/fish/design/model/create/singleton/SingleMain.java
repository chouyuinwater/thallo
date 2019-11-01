package com.fish.design.model.create.singleton;

import product.impl.PlayStation4;

public class SingleMain {
    public static void main(String[] args) {
        Singleton singleton1 = new Singleton();
        Singleton singleton2 = new Singleton();
        Singleton singleton3 = new Singleton();

        PlayStation4 ps1 = singleton1.getInstance();
        PlayStation4 ps2 = singleton2.getInstance();
        PlayStation4 ps3 = singleton3.getInstance();

        System.out.println("ps1 = " + ps1.hashCode());
        System.out.println("ps2 = " + ps2.hashCode());
        System.out.println("ps3 = " + ps3.hashCode());

        Singleton singleton4 = new Singleton();
        Singleton singleton5 = new Singleton();
        Singleton singleton6 = new Singleton();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton7 = new Singleton();
                PlayStation4 ps7 = singleton7.getInstanceDCL();
                System.out.println("ps7 = " + ps7.hashCode());

                PlayStation4 ps10 = singleton7.getInstance();
                System.out.println("ps10 = " + ps10.hashCode());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton8 = new Singleton();
                PlayStation4 ps8 = singleton8.getInstanceDCL();
                System.out.println("ps8 = " + ps8.hashCode());

                PlayStation4 ps11 = singleton8.getInstance();
                System.out.println("ps11 = " + ps11.hashCode());
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton9 = new Singleton();
                PlayStation4 ps9 = singleton9.getInstanceDCL();
                System.out.println("ps9 = " + ps9.hashCode());

                PlayStation4 ps12 = singleton9.getInstance();
                System.out.println("ps12 = " + ps12.hashCode());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        PlayStation4 ps4 = singleton4.getInstanceDCL();
        PlayStation4 ps5 = singleton5.getInstanceDCL();
        PlayStation4 ps6 = singleton6.getInstanceDCL();

        System.out.println("ps4 = " + ps4.hashCode());
        System.out.println("ps5 = " + ps5.hashCode());
        System.out.println("ps6 = " + ps6.hashCode());

    }
}
