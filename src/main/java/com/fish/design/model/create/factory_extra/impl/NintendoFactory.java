package com.fish.design.model.create.factory_extra.impl;

import common.Contant;
import model.create.factory_extra.Factory;
import product.Game;
import product.impl.FireEmblemAwakening;
import product.impl.FireEmblemIf;
import product.impl.FireEmblemRadiantDawn;

public class NintendoFactory implements Factory {

    @Override
    public Game getGame(String name) {
        if (Contant.FE_AWAKE.equals(name)) {
            return new FireEmblemAwakening();
        } else if (Contant.FE_IF.equals(name)) {
            return new FireEmblemIf();
        } else if (Contant.FE_RD.equals(name)) {
            return new FireEmblemRadiantDawn();
        }
        return null;
    }

    @Override
    public Game getGame(Object deploy) {
        return null;
    }
}
