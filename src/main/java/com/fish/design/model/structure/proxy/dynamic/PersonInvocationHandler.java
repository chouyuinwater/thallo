package com.fish.design.model.structure.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonInvocationHandler<T> implements InvocationHandler {
    private T target;

    public PersonInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在转调具体目标对象之前，可以执行一些功能处理
        System.out.println("被动态代理类回调执行, 代理类 proxyClass ="+proxy.getClass()+" 方法名: " + method.getName() + "方法. 方法返回类型："+method.getReturnType()
                +" 接口方法入参数组: "+(args ==null ? "null" : Arrays.toString(args)));
        // 加入统一处理的代理逻辑
        System.out.println("ProxySubject is HERE!");
        method.invoke(target, args);
        System.out.println("POWER is HERE!");


        return null;
    }
}
