package com.fish.design.model.create.abs_factory.factory;

import com.fish.design.product.Console;
import com.fish.design.product.Display;
import com.fish.design.product.Game;
import com.fish.design.product.Sound;

public interface Factory {
    Console getConsole();

    Display getDisplay();

    Game getGame();

    Sound getSound();
}
