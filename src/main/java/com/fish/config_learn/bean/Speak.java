package com.fish.config_learn.bean;

public class Speak {

    private Chinese chinese;

    public String speakSomething() {
        return chinese.getName();
    }

    public Chinese getChinese() {
        return chinese;
    }

    public void setChinese(Chinese chinese) {
        this.chinese = chinese;
    }
}
