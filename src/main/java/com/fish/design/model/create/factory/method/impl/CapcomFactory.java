package com.fish.design.model.create.factory.method.impl;

import common.Contant;
import model.create.factory.method.Factory;
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
