package com.fish.concurrent.main;

/**
 * 线程父类
 */
public abstract class AbstractThread extends Thread {

    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        runWorker();
    }

    /**
     * 多线程实现
     */
    public abstract void runWorker();
}
