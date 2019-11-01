package com.fish.design.model.behavior.strategy.impl;

import model.behavior.strategy.Strategy;

public class AddInt implements Strategy {
    @Override
    public int doMain(int a, int b) {
        return a + b;
    }
}
