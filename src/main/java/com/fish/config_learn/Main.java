package com.fish.config_learn;

import com.fish.config_learn.bean.Speak;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-main.xml");
        Speak test = (Speak)ctx.getBean("speak");
        System.out.println(test.speakSomething());
        ArrayList

    }
}
