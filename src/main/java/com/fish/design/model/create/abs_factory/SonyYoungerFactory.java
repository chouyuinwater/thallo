package com.fish.design.model.create.abs_factory;


import com.fish.design.model.create.abs_factory.factory.Factory;
import com.fish.design.product.Console;
import com.fish.design.product.Display;
import com.fish.design.product.Game;
import com.fish.design.product.Sound;
import com.fish.design.product.impl.BoseNormal;
import com.fish.design.product.impl.DellQ27;
import com.fish.design.product.impl.MonsterHunterWorld;
import com.fish.design.product.impl.PlayStation4;

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
