package com.fish.design.model.create.abs_factory;

import model.create.abs_factory.factory.Factory;
import product.Console;
import product.Display;
import product.Game;
import product.Sound;
import product.impl.BoseHigh;
import product.impl.DellQ25;
import product.impl.MonsterHunterXX;
import product.impl.Switch;

public class NintendoPiggyFactory implements Factory {
    @Override
    public Console getConsole() {
        return new Switch();
    }

    @Override
    public Display getDisplay() {
        return new DellQ25();
    }

    @Override
    public Game getGame() {
        return new MonsterHunterXX();
    }

    @Override
    public Sound getSound() {
        return new BoseHigh();
    }
}
