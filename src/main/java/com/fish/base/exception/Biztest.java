package com.fish.base.exception;

public class Biztest {
    public void test(int a) throws Exception {
        if (a == 1) {
            throw new Exception("1");
        }
        if (a == 2) {
            throw new RuntimeException("2");
        }
        if (a == 3) {
            throw new BizException("3");
        }
    }
}
