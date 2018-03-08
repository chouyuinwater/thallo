package com.fish.config_learn.bean;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Speak {

    @Autowired
    private Language chinese;

    @Resource
    private Language english;

    public String speakSomething() {
        return chinese.getName() + " and " + english.getName();
    }

//    public Language getChinese() {
//        return chinese;
//    }
//
//    public Language getEnglish() {
//        return english;
//    }

//    public void setEnglish(Language english) {
//        this.english = english;
//    }
//
//    public void setChinese(Language chinese) {
//        this.chinese = chinese;
//    }
}
