package com.fish.design.model.create.factory_extra;

import com.fish.design.product.Game;

public interface Factory {
    Game getGame(String name);

    Game getGame(Object deploy);
}
