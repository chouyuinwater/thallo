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
     *
     * 栈后进先出 LIFO 限定仅在表尾进行插入或删除操作的线性表。
     * 也就是说它有两个操作,且操作数都在线性表尾部
     * 队列先进先出 FIFO 是一种特殊的线性表，它只允许在表的前端（front）进行删除操作，
     * 而在表的后端（rear）进行插入操作。
     *
     * 插入元素先放入Stack1， 需要先将保存在Stack2的元素按顺序转移会Stack1，再把新插入元素放入队列尾部
     * 删除时把Stack1的元素（从后往前弹出元素）弹出到Stack2中，再弹出Stack2
     *
     * 两个瓶子互相倒水
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
     *
     * queue1 保存元素
     * 删除时把元素放入另一个队列，将最后一个元素删除，本队列清空
     */
    private class TwoQueueMakeStack<T> {
        private Queue<T> queue1 = new ArrayDeque<>();
        private Queue<T> queue2 = new ArrayDeque<>();

        public T push(T element) {
            queue1.offer(element);
            return element;
        }

        public T pop() {
            if (queue1.size() > 0) {
                while (queue1.size() > 1) {
                    queue2.offer(queue1.poll());
                }
                return queue1.poll();
            }
            if (queue2.size() > 0) {
                while (queue2.size() > 1) {
                    queue1.offer(queue2.poll());
                }
                return queue2.poll();
            }
            return null;
        }
    }
}
