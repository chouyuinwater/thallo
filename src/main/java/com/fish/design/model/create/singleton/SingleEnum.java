package com.fish.design.model.create.singleton;

public enum SingleEnum {

    SINGLETON("single");

    private String name;

    SingleEnum(String name) {
        this.name = name;
    }

    public void doSomething(String name) {
        System.out.println(name);
    }
}
