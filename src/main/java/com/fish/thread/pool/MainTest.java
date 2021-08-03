package com.fish.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jiangbing
 * @date 2021/6/4 16:28
 * notes and tips:
 */
public class MainTest {


    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5,
            1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactory() {
        /**
         * Constructs a new {@code Thread}.  Implementations may also initialize
         * priority, name, daemon status, {@code ThreadGroup}, etc.
         *
         * @param r a runnable to be executed by new thread instance
         * @return constructed thread, or {@code null} if the request to
         * create a thread is rejected
         */
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "executor-" + System.currentTimeMillis());
        }
    });

    public static void main(String[] args) {
        setHook();

        executor.allowCoreThreadTimeOut(true);
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("main over");
//        System.exit(0);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        executor.shutdown();
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("main overII");
    }


    private static void setHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("pool end");
            executor.shutdown(); // Disable new tasks from being submitted
            // 设定最大重试次数
            try {
                // 等待 60 s
                if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                    // 调用 shutdownNow 取消正在执行的任务
                    executor.shutdownNow();
                    // 再次等待 60 s，如果还未结束，可以再次尝试，或则直接放弃
                    if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                        System.err.println("线程池任务未正常执行结束");
                    }
                }
            } catch (InterruptedException ie) {
                System.out.println("pool endII");
                // 重新调用 shutdownNow
                executor.shutdownNow();
            }
            System.out.println("pool endIII");
        }));
    }
}
