package com.fish.design.model.structure.bridge.impl;

import com.fish.design.model.structure.bridge.AbstractPen;
import com.fish.design.model.structure.bridge.Ink;

public class HardPen extends AbstractPen {
    public HardPen(Ink ink) {
        super(ink);
    }

    @Override
    protected void usePen() {
        System.out.println("use hard pen!");
    }
}
