package com.fish.thread.see_volatile;


import com.fish.thread.bean.UserInfo;

public class VolatileSetFlag implements Runnable {
    private UserInfo userInfo;

    @Override
    public void run() {
        userInfo.setSex((byte)1);
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " set flag = " + userInfo.toString());
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
