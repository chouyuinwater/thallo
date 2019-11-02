package com.fish.design.model.structure.proxy;

/**
 * 真实业务逻辑实现
 */
public class RealSubject implements Subject {
    @Override
    public void sayHello() {
        System.out.println("Hello!");
    }
}
