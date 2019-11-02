package com.fish.design.model.structure.proxy;

/**
 * 代理类
 */
public class Proxy implements Subject {

    private Subject subject;
    @Override
    public void sayHello() {
        subject.sayHello();
        afterProccess();
    }

    private void afterProccess() {
        System.out.println("World!");
    }

    public Proxy(Subject subject) {
        this.subject = subject;
    }
}
