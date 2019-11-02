package com.fish.design.model.create.factory.method;

import com.fish.design.product.Game;

public interface Factory {
    Game getGame(String name);
}
