package com.fish.design.model.create.factory.method;

import product.Game;

public interface Factory {
    Game getGame(String name);
}
