package com.fish.design.model.structure.decorator.decorat.impl;

import model.structure.decorator.Component;
import model.structure.decorator.decorat.Decorator;

public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        addContent();
    }

    public void addContent() {
        System.out.println("ConcreteDecoratorB");
    }
}
