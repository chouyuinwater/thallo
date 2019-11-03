package com.fish.design.model.structure.proxy.dynamic;

public class SoftwareEngineer implements Person {
    @Override
    public void willPower(String power) {
        System.out.println("See my POWER!! " + power);
    }
}
