package com.fish.design.model.structure.bridge;

import model.structure.bridge.impl.HardPen;
import model.structure.bridge.impl.RedInk;

public class BridgeMain {
    public static void main(String[] args) {
        Ink ink = new RedInk();
        Pen pen = new HardPen(ink);
        pen.write();
    }
}
