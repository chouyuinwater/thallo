package com.fish.design.model.create.singleton;

import product.impl.PlayStation4;

public class Singleton {

    private final static PlayStation4 ps = new PlayStation4();

    private static PlayStation4 ps_safe;

    public PlayStation4 getInstance() {
        return ps;
    }

    public PlayStation4 getInstanceDCL() {
        if (ps_safe == null) {
            synchronized (Singleton.class) {
                if (ps_safe == null) {
                    ps_safe = new PlayStation4();
                }
            }
        }
        return ps_safe;
    }
}
