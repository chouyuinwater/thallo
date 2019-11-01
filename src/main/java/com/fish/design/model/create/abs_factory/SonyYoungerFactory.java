package com.fish.design.model.create.abs_factory;

import model.create.abs_factory.factory.Factory;
import product.Console;
import product.Display;
import product.Game;
import product.Sound;
import product.impl.BoseNormal;
import product.impl.DellQ27;
import product.impl.MonsterHunterWorld;
import product.impl.PlayStation4;

public class SonyYoungerFactory implements Factory {
    @Override
    public Console getConsole() {
        return new PlayStation4();
    }

    @Override
    public Display getDisplay() {
        return new DellQ27();
    }

    @Override
    public Game getGame() {
        return new MonsterHunterWorld();
    }

    @Override
    public Sound getSound() {
        return new BoseNormal();
    }
}
