package com.fish.design.model.create.abs_factory.factory;

import product.Console;
import product.Display;
import product.Game;
import product.Sound;

public interface Factory {
    Console getConsole();

    Display getDisplay();

    Game getGame();

    Sound getSound();
}
