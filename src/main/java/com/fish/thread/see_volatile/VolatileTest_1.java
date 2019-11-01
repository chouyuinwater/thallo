package com.fish.thread.see_volatile;


import com.fish.thread.bean.UserInfo;

public class VolatileTest_1 {
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
