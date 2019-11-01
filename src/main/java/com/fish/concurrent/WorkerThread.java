package com.fish.concurrent;


import com.fish.concurrent.main.AbstractThread;

public class WorkerThread extends AbstractThread {

    /**
     * 多线程实现
     */
    @Override
    public void runWorker() {
        System.out.println(Thread.currentThread().getName() + " is here work");
    }
}
