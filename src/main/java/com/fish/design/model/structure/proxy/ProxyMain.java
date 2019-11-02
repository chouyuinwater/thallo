package com.fish.design.model.structure.proxy;

/**
 * 代理模式
 */
public class ProxyMain {

    /**
     * 意图：为其他对象提供一种代理以控制这个对象的访问
     *
     * 动机：队以个对象进行访问控制的一个原因是为了只有在我们确定需要这个对象时才对它进行创建和初始化
     * Proxy常见情况：
     * 1. 远程代理，为一个对象在不同的地址空间提供局部代表。
     * 2. 虚代理，根据需要创建开销很大的对象。
     * 3. 保护代理，控制对原始对象的访问。保护代理用于对象应该有不同的访问权限的时候。
     * 4. 智能指引，取代了简单的指针，他在访问对象时执行一些附加的操作
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.sayHello();
    }
}
