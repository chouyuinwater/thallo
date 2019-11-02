package com.fish.design.model.structure.decorator.decorat.impl;

import com.fish.design.model.structure.decorator.Component;
import com.fish.design.model.structure.decorator.decorat.Decorator;

/**
 * 装饰组件的类。调用组件的业务，同时添加装饰内容
 */
public class ConcreteDecoratorA extends Decorator {

    /**
     * 一个类（如：ClassA），如果没有声明任何构造函数，那么系统会自动生成一个无参构造函数，
     * 此时使用ClassA myClass = new ClassA（），不会报错。
     * 但是，如果显式声明了一个有参构造函数，却没有声明一个无参构造函数的话，系统不会自动生成一个无参构造函数，
     * 此时，再使用ClassA myClass = new ClassA（）就会报错。如果要消除报错，则必须使用有参构造函数，或者添加一个无参构造函数。
     * 所以，一个类的构造函数，一般只有三种状况：无参 或者 无参 + 有参 或者 有参
     *
     * 在继承关系中，子类的所有构造函数（包括无参构造函数（默认构造函数），有参构造函数等），如果不显式声明调用哪种
     * super，那么都会默认调用super（），即都会默认调用父类的无参构造函数（默认构造函数）。而，如果父类此时没有无参构造
     * 函数存在的话，就会报错。为了修改报错，只能显式调用父类显式声明的构造函数之一或者在父类中增加无参构造函数。
     * @param component
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void display() {
        super.display();
        addContent();
    }

    public void addContent() {
        System.out.println("ConcreteDecoratorA");
    }
}
