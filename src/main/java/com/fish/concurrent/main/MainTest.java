package com.fish.concurrent.main;


import com.fish.concurrent.WorkerThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MainTest {
    public static void main(String[] args) {

        Runnable run = () -> {
            System.out.println(Thread.currentThread().getName() + " is here run");
        };

        Callable<String> call = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is here call");
            System.out.println("aaaa");
            return name;
        };

        WorkerThread thread = new WorkerThread();

        Thread thread1 = new Thread(run);

        FutureTask<String> futureTask = new FutureTask<>(call);
        Thread thread2 = new Thread(futureTask);

        System.out.println(Thread.currentThread().getName());
        thread.run();
        thread1.run();
        thread2.run();



        thread.start();
        thread1.start();
        thread2.start();

        Long a = 11L;
        a.intValue();

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(futureTask.get() + " get");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
