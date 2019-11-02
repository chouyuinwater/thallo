package com.fish.design.model.structure.decorator.concrete;

import com.fish.design.model.structure.decorator.Component;

public class ConcreteComponentB implements Component {
    @Override
    public void display() {
        System.out.println("ConcreteComponentB");
    }
}
