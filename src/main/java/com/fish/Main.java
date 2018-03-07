package com.fish;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-main.xml");
        Test test = (Test)ctx.getBean("test");
        System.out.println(test.getName());
    }
}
