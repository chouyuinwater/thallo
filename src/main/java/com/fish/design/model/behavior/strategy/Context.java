package com.fish.design.model.behavior.strategy;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int execute(int a, int b) {
        return strategy.doMain(a, b);
    }
}
