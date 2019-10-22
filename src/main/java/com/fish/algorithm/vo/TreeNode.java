package com.fish.algorithm.vo;

public class TreeNode<T> {
    private T value;
    private TreeNode<T> parentNode;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode() {
    }

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", parentNode=" + parentNode +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
