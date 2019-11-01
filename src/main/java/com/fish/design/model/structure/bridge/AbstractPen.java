package com.fish.design.model.structure.bridge;

public abstract class AbstractPen implements Pen {
    private Ink ink;
    public AbstractPen(Ink ink) {
        this.ink = ink;
    }

    @Override
    public void write() {
        ink.color();
        usePen();
    }

    protected abstract void usePen();
}
