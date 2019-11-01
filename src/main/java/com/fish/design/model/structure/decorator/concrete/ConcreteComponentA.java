package com.fish.design.model.structure.decorator.concrete;

import model.structure.decorator.Component;

/**
 * 具体的组件
 */
public class ConcreteComponentA implements Component {
    @Override
    public void display() {
        System.out.println("ConcreteComponent");
    }
}
