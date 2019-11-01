package com.fish.extent;

public class Son extends Father {
    public Son() {
        // 默认执行
//        super();
        System.out.println("son");
    }

    public void showFather() {
        super.showFather();
        showSon();

    }

    public void showSon() {
        System.out.println("son");
    }

}
