package com.fish.config_learn;

import com.fish.config_learn.bean.Speak;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/config_learn/spring-main.xml");
        Speak test = (Speak)ctx.getBean("speak");
        System.out.println(test.speakSomething());
    }
}
