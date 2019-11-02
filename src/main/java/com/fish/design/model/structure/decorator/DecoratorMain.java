package com.fish.design.model.structure.decorator;

import com.fish.design.model.structure.decorator.concrete.ConcreteComponentA;
import com.fish.design.model.structure.decorator.decorat.impl.ConcreteDecoratorA;
import com.fish.design.model.structure.decorator.decorat.impl.ConcreteDecoratorB;

public class DecoratorMain {
    public static void main(String[] args) {
        /**
         * 半透明模式/透明模式
         * 适配模式与装饰模式
         *
         * 可以对同一对象进行多次装饰，所有类全部声明为同一接口
         */
        // 透明模式
        Component concreteComponentA = new ConcreteComponentA();
        Component concreteDecoratorA = new ConcreteDecoratorA(concreteComponentA);
        Component concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA);
        concreteDecoratorA.display();
        concreteDecoratorB.display();
        // 半透明模式
        ConcreteDecoratorA concreteDecoratorA1 = new ConcreteDecoratorA(concreteComponentA);
        concreteDecoratorA1.addContent();
    }

}
