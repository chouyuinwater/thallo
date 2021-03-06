package com.fish.design.model.create.abs_factory;

import com.fish.design.model.create.abs_factory.factory.Factory;
import com.fish.design.product.Console;
import com.fish.design.product.Display;
import com.fish.design.product.Game;
import com.fish.design.product.Sound;

/**
 * 抽象工厂模式
 * http://design-patterns.readthedocs.io/zh_CN/latest/index.html
 * GoF-Design Patterns: Elements of Reusable Object-Oriented Software
 */
public class FactoryMain {
    /**
     * 1.意图
     * 提供一个创建一系列相关或互相依赖对象的接口，而无需指定它们具体的类
     * 2.适用性
     * 在以下情况可以使用Abstract Factory模式
     * 一个系统要独立于它的产品的创建、组合和表示时
     * 一个系统要由多个产品系列中的一个来配置时
     * 当你要强调一系列相关的产品对象的设计以便进行联合使用时
     * 当你要提供一个产品类库，而只想显示它们的接口而不是实现时
     * 3.优缺点
     * 它分离了具体的类
     * 它使得易于交换产品系列
     * 它有利于产品的一致性
     * 难以支持新种类的产品
     * @param args
     */
    public static void main(String[] args) {
        /*
         * 无论是简单工厂模式，工厂方法模式，还是抽象工厂模式，他们都属于工厂模式。
         * 他们的最终目的都是为了=====解耦=====。
         * 我们不必去在意这个模式到底工厂方法模式还是抽象工厂模式，只需要关心降低耦合度的目的是否达到了。
         *
         * 优点
         * 抽象工厂模式除了具有工厂方法模式的优点外，最主要的优点就是可以在类的内部对产品族进行约束
         * 所谓的产品族，一般或多或少的都存在一定的关联，
         * 抽象工厂模式就可以在类内部对产品族的关联关系进行定义和描述，而不必专门引入一个新的类来进行管理。
         * 缺点
         * 产品族的扩展将是一件十分费力的事情，假如产品族中需要增加一个新的产品，则几乎所有的工厂类都需要进行修改。
         * 所以使用抽象工厂模式时，对产品等级结构的划分是非常重要的
         *
         * 明白了等级结构和产品族的概念，就理解工厂方法模式和抽象工厂模式的区别了，
         * 如果工厂的产品全部属于同一个等级结构，则属于工厂方法模式；
         * 如果工厂的产品来自多个等级结构，则属于抽象工厂模式。
         *
         * 等级结构横向划分，产品族纵向划分
         * 产品等级结构 ：
         * 产品等级结构即产品的继承结构，如一个抽象类是电视机，
         * 其子类有海尔电视机、海信电视机、TCL电视机，
         * 则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，
         * 抽象电视机是父类，而具体品牌的电视机是其子类。
         *
         * 产品族 ：在抽象工厂模式中，产品族是指由同一个工厂生产的，
         * 位于不同产品等级结构中的一组产品，如海尔电器工厂生产的海尔电视机、
         * 海尔电冰箱，海尔电视机位于电视机产品等级结构中，
         * 海尔电冰箱位于电冰箱产品等级结构中。
         *
         * 当系统所提供的工厂所需生产的具体产品并不是一个简单的对象，
         * 而是多个位于不同产品等级结构中属于不同类型的具体产品时需要使用抽象工厂模式。
         *
         * 抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形态。
         *
         * 抽象工厂模式与工厂方法模式最大的区别在于，
         * 工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构，
         * 一个工厂等级结构可以负责多个不同产品等级结构中的产品对象的创建 。
         * 当一个工厂等级结构可以创建出分属于不同产品等级结构的一个产品族中的所有对象时，
         * 抽象工厂模式比工厂方法模式更为简单、有效率。
         *
         * ********************************注意******************************* *
         * 本例工厂模式 不可扩展。                                                *
         * 一旦需要加入新的产品需要增加新的接口进而修改工程类及其所有种子类              *
         * 利用基于原型的工厂模式可解决这个问题，见package factory                   *
         * ********************************注意******************************* *
         */
        Factory factory = new SonyYoungerFactory();

        Console console = factory.getConsole();
        Display display = factory.getDisplay();
        Game game = factory.getGame();
        Sound sound = factory.getSound();

        System.out.println("info: " + console.getName() +
                display.getName() + game.getName() + sound.getName());

    }
}
