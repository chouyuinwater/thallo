package com.fish.design.model.create.factory.method.impl;

import com.fish.design.common.Contant;


import com.fish.design.model.create.factory.method.Factory;
import com.fish.design.product.Game;
import com.fish.design.product.impl.MonsterHunter4G;
import com.fish.design.product.impl.MonsterHunterWorld;
import com.fish.design.product.impl.MonsterHunterXX;

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
