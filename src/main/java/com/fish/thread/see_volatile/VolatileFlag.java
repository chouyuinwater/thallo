package com.fish.thread.see_volatile;


import com.fish.thread.bean.UserInfo;

public class VolatileFlag implements Runnable {
    private UserInfo userInfo;
    // volatile 保证可见性不保证原子性
//    private volatile UserInfo userInfo;

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() +
                " " + Thread.currentThread().getName() + " start = " + userInfo.toString());
        long old = System.currentTimeMillis();
        byte sex;
        for (; ;) {
            sex = userInfo.getSex();
            if (sex == 1) {
                System.out.println(System.currentTimeMillis() + " in flag = " + userInfo.toString());
                return;
            }

            // 同步
//            String msg = userInfo.toString();
            // 不同步
//            byte a = userInfo.getSex();
            if (System.currentTimeMillis() - old > 5000) {
                // 同步
                String msg = userInfo.toString();
//                if (userInfo.getSex() == 1) {
//                    String msg = userInfo.toString();
//                    System.out.println(System.currentTimeMillis() +
//                            " " + Thread.currentThread().getName() + " end = " + msg);
//                }
//                System.out.println(sex);
                // 同步
                byte a = userInfo.getSex();
                System.out.println(System.currentTimeMillis() +
                            " " + Thread.currentThread().getName() + " end = " + sex + " " + a + " " + msg);

                return;
            }
//            synchronized (this) {
//                使缓存失效，所有的对象要重新取
//            }

//            String msg = userInfo.toString();
            // println 为同步方法 会刷新缓存
//            System.out.println(System.currentTimeMillis() + " out flag = " + msg);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
