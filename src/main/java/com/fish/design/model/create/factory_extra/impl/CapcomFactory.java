package com.fish.design.model.create.factory_extra.impl;

import common.Contant;
import model.create.factory_extra.Factory;
import product.Game;
import product.impl.MonsterHunter4G;
import product.impl.MonsterHunterWorld;
import product.impl.MonsterHunterXX;

public class CapcomFactory implements Factory {

    @Override
    public Game getGame(String name) {
        if (Contant.MH_XX.equals(name)) {
            return new MonsterHunterXX();
        } else if (Contant.MH_WORLD.equals(name)) {
            return new MonsterHunterWorld();
        } else if (Contant.MH_4G.equals(name)) {
            return new MonsterHunter4G();
        }
        return null;
    }

    @Override
    public Game getGame(Object deploy) {
        // 生成对象时可能需要各种配置，根据不同的传入参数进行设置，返回对象。
        return null;
    }

    /**
     * 简单工厂模式
     * @param name
     * @return
     */
    public static Game getNewGame(String name) {
        if (Contant.MH_XX.equals(name)) {
            return new MonsterHunterXX();
        } else if (Contant.MH_WORLD.equals(name)) {
            return new MonsterHunterWorld();
        } else if (Contant.MH_4G.equals(name)) {
            return new MonsterHunter4G();
        }
        return null;
    }


}
