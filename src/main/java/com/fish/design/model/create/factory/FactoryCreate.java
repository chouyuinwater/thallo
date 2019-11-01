package com.fish.design.model.create.factory;

import common.Contant;
import model.create.factory.method.Factory;
import model.create.factory.method.impl.CapcomFactory;
import model.create.factory.method.impl.NintendoFactory;

public class FactoryCreate {

    public Factory getFactory(String name) {
        if (Contant.CAPCOM.equals(name)) {
            return new CapcomFactory();
        } else if (Contant.NINTENDO.equals(name)) {
            return new NintendoFactory();
        }
        return null;
    }

    public Factory getCopcomFactory() {
        return new CapcomFactory();
    }

    public Factory getNintendo() {
        return new NintendoFactory();
    }
}
