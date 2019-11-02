package com.fish.design.model.create.factory_extra;

import com.fish.design.common.Contant;
import com.fish.design.product.Game;

/**
 * 工厂模式
 */
public class FactoryMain {
    public static void main(String[] args) {
        /*
         * 工厂模式补充，利用反射生成对象
         */
        Factory factory = (Factory) FactoryUtil.getBean();
        // 这里的方法应该修改 反射生成的类，调用的方法应该是一样的
        // 例如Game copcomGame = factory.getGame(); 在接口中设计方法
        Game copcomGame = factory.getGame(Contant.MH_WORLD);
        System.out.println("I want to play " + copcomGame.getName());
    }
}
