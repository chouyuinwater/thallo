package com.fish.thread.see_volatile;


import com.fish.thread.bean.UserInfo;

import java.util.Random;

public class VolatileRunnable implements Runnable {

    private UserInfo userInfo;

    public VolatileRunnable(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {

        try {
            System.out.println(System.currentTimeMillis() + " begin " + Thread.currentThread().getName() + " " + userInfo.toString());
            Thread.sleep(10);
            System.out.println(System.currentTimeMillis() + " begin " + Thread.currentThread().getName() + " " + userInfo.toString());
            userInfo.setId(new Random().nextLong());
            userInfo.setName("b");
            System.out.println(System.currentTimeMillis() + " end " + Thread.currentThread().getName() + " " +  userInfo.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
