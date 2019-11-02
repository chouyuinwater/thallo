package com.fish.design.model.create.abs_factory;

import com.fish.design.model.create.abs_factory.factory.Factory;
import com.fish.design.product.Console;
import com.fish.design.product.Display;
import com.fish.design.product.Game;
import com.fish.design.product.Sound;
import com.fish.design.product.impl.BoseHigh;
import com.fish.design.product.impl.DellQ25;
import com.fish.design.product.impl.MonsterHunterXX;
import com.fish.design.product.impl.Switch;

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
