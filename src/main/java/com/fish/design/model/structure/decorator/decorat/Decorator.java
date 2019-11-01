package com.fish.design.model.structure.decorator.decorat;

import model.structure.decorator.Component;

/**
 * 装饰类的父类 引入组件
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
