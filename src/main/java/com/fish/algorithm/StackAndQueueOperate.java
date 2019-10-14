package com.fish.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 栈、队列算法
 */
public class StackAndQueueOperate {

    private Queue twoStackMakeOneQueue() {
        // Dqueue 是双端队列
        Queue<Integer> integerQueue = new ArrayDeque<>();
        integerQueue = new LinkedBlockingDeque<>();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        return integerQueue;
    }

    private class TwoStackMakeOneQueue {
        private Stack stack1 = new Stack();
        private Stack stack2 = new Stack();

    }
}
