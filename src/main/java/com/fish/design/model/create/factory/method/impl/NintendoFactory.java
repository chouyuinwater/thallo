package com.fish.design.model.create.factory.method.impl;

import com.fish.design.common.Contant;
import com.fish.design.model.create.factory.method.Factory;
import com.fish.design.product.Game;
import com.fish.design.product.impl.FireEmblemAwakening;
import com.fish.design.product.impl.FireEmblemIf;
import com.fish.design.product.impl.FireEmblemRadiantDawn;

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
}
