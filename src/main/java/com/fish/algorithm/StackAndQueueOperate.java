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

    /**
     * 双栈实现队列
     */
    private class TwoStackMakeOneQueue<T> {
        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public T offer(T element) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(element);
            return element;
        }

        public T pool() {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    /**
     * 双队列实现栈
     */
    private class TwoQueueMakeStack {

    }
}
