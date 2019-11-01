package com.fish.extent;

public class ExtentMain {
    public static void main(String[] args) {
        System.out.println("=============");
        Father father = new Father();
        System.out.println("=============");
        Son son = new Son();
        System.out.println("=============");
        father.setFather(son);
        System.out.println("=============");
        // java.lang.NullPointerException
//        father.showFather();
        System.out.println("=============");
        // java.lang.NullPointerException
//        son.showFather();
        System.out.println("=============");
    }
}
