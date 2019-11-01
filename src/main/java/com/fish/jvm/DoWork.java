package com.fish.jvm;

public class DoWork {
    private static String STA_S_A = "Strstatic";

    private final String FINAL_S_A = "Strfinal";

    private static Something STA_POJO_B = new Something();

    private final Something FINAL_POJO_B = new Something();

    private void doSomething() {
        final String methodString = "methodStr";
        final Something methodStringPojo = new Something();
    }

    public static void main(String[] args) {
        new DoWork().doSomething();
    }
 }
