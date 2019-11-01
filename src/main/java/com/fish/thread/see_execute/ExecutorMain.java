package com.fish.thread.see_execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorMain {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
    }
}
