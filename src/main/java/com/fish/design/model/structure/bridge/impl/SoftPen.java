package com.fish.design.model.structure.bridge.impl;

import com.fish.design.model.structure.bridge.AbstractPen;
import com.fish.design.model.structure.bridge.Ink;

public class SoftPen extends AbstractPen {
    public SoftPen(Ink ink) {
        super(ink);
    }

    @Override
    protected void usePen() {
        System.out.println("use soft pen");
    }
}
