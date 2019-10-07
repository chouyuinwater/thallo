package com.fish.algorithm;

import com.fish.algorithm.vo.Node;

import java.util.LinkedList;

/**
 * 链表相关算法
 */
public class LinkListOperate {

    public static void main(String[] args) {

        LinkedList<Node> nodeLinkedList = getLinkedList();
        for (int i = 0; i < nodeLinkedList.size() ; i++) {
            System.out.println(nodeLinkedList.get(i).getId());
        }
        turnLinkedList(nodeLinkedList);
        for (int i = 0; i < nodeLinkedList.size() ; i++) {
            System.out.println(nodeLinkedList.get(i).getId());
        }

    }

    private static LinkedList<Node> getLinkedList() {
        LinkedList<Node> nodeList = new LinkedList<>();
        for (int i = 0; i < 5 ; i++) {
            Node node = new Node();
            node.setId(i);
            node.setNo(String.valueOf(i));
            node.setName("name_" + i);
            nodeList.add(node);
        }
        return nodeList;
    }

    /**
     * 第三题
     * 反转单链表 - 递归
     * 不改变链表结构，不使用循环
     * 使用递归反转链表本质上是利用栈后进先出的特点。使用此方法要注意栈深度问题，有可能造成栈MMO
     *
     * 总结：在解决循环问题是可以考虑使用递归来达到同样的效果，不单单局限于for循环(别忘了while)
     */
    private static LinkedList<Node> turnLinkedList(LinkedList<Node> nodeList) {
        if (nodeList.size() == 2) {
            Node lastNode = nodeList.removeLast();
            nodeList.addFirst(lastNode);
            return nodeList;
        }
        Node lastNode = nodeList.removeLast();
        nodeList = turnLinkedList(nodeList);
        nodeList.addFirst(lastNode);
        return nodeList;
    }
}
