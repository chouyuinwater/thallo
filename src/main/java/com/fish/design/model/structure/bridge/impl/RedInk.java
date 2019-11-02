package com.fish.design.model.structure.bridge.impl;

import com.fish.design.model.structure.bridge.Ink;

public class RedInk implements Ink {
    @Override
    public void color() {
        System.out.println("use red ink!");
    }
}
