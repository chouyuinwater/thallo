package com.fish.algorithm;

import com.fish.algorithm.vo.TreeNode;

import java.util.Arrays;

/**
 * 树的相关算法
 *
 * 树是一种在编程中经常遇到的数据结构。他的逻辑很简单：
 * 除了根节点以外，每个节点只有一个父节点，根节点没有父节点；
 * 除了叶节点以外所有的节点都有一个或多个子节点
 * 叶节点没有子节点
 * 父节点和子节点之间用指针链接
 *
 * 二叉树是树的一种特殊结构，在二叉树中每个节点最多只能由两个子节点
 * 二叉树中最重要的操作莫过于遍历 即按照某一顺序访问书中的所有节点
 *
 *
 *         10
 *     6       14
 *  4    8   12   16
 *
 *  前序遍历：先访问根节点，在访问左子节点，再访问右子节点
 *  10 6 4 8 14 12 16
 *  中序遍历：先访问左子节点，再访问根节点，最后访问右子节点
 *  4 6 8 10 12 14 16
 *  后序遍历：先访问左子节点，再访问右子节点，最后访问根节点
 *  4 8 6 12 16 14 10
 *
 *  二叉树遍历以根节点为开始 根节点左面为左子节点，根节点右面为右子节点
 *  前序遍历显示根节点， 然后是处理左面的子节点做处理（递归处理左面的子节点），左面的子节点处理完毕之后返回到根节点
 *  再处理右面的子节点（递归处理右面的子节点）
 *
 *  树的遍历
 *  宽度优先遍历：先访问树的第一层节点，再访问树的第二层节点，一直到访问到最下面一层节点。
 *  在同一层节点中，以从左到右的顺序依次访问
 *  我们可以对包括二叉树在内的所有的树进行宽度优先遍历
 *  10 6 14 4 8 12 16
 *
 *
 *
 */
public class TreeOperate {
    public static void main(String[] args) {
        TreeNode treeNode = reconstructingBinaryTree();
        System.out.println("=============");
        preorderTraversal(treeNode);
        System.out.println("=============");
        sequentialTraversal(treeNode);
        System.out.println("=============");
        postOrderTraversal(treeNode);
        System.out.println("=============");
    }

    /**
     * 第7题
     * 重建二叉树
     * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
     * 假设输入的前序遍历和中序遍历的结果都不含重复的的数字
     * 例如：输入前序遍历数列{1, 2, 4, 7, 3, 5, 6, 8}
     * 和中序遍历数列{4, 7, 2, 1, 5, 3, 8, 6}, 则重建二叉树
     * 树节点定义为TreeNode
     *
     * 思路：前序遍历的第一个元素一定是根节点
     * 在中序遍历中找到根节点，则根节点前面的就是所有的左子节点，根节点跟后面的就是所有的右子节点
     * 此时返回的根节点就是当前前序遍历和中序遍历描述的树
     * 设置该根节点的左右子节点则传入根节点前面的就是所有的左子节点的前序遍历和中序遍历获取根节点
     * 和根节点后面的就是所有的右子节点的前序遍历和中序遍历获取根节点
     * 由此递归下去，直到不再存在遍历数组说明不存在该节点 返回Null
     *
     * 总结：1. 掌握前序遍历、中序遍历和后序遍历的方法与规则，能够确定二叉树的基本节点信息
     *      2. 使用递归可以轻松解决二叉树相关问题
     *      3. 递归的特点是重复利用一个规则层层递进
     */
    private static TreeNode reconstructingBinaryTree() {
        int[] q = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] z = {4, 7, 2, 1, 5, 3, 8, 6};
        return getTree(q, z);
    }

    private static TreeNode getTree(int[] q, int[] z) {
        if (q.length == 0 || z.length == 0) {
            return null;
        }

        TreeNode rootTreeNode = new TreeNode();
        int rootValue = q[0];
        int index = -1;
        for (int i = 0; i < z.length; i++) {
            if (rootValue == z[i]) {
                index = i;
            }
        }
        if (index == -1) {
            throw new RuntimeException("wrong array");
        }
        rootTreeNode.setValue(rootValue);
        // 重复利用一个规则层层递进
        rootTreeNode.setLeftNode(getTree(Arrays.copyOfRange(q, 1, index + 1), Arrays.copyOfRange(z, 0, index)));
        rootTreeNode.setRightNode(getTree(Arrays.copyOfRange(q, index + 1, q.length), Arrays.copyOfRange(z, index + 1, z.length)));

        return rootTreeNode;
    }

    /**
     * 前序遍历：先访问根节点，在访问左子节点，再访问右子节点
     * @param treeNode 节点
     *
     * 人肉去计算遍历的时候要使用层的概念 到这一层往下执行完再回来
     */
    private static void preorderTraversal(TreeNode treeNode) {
        System.out.println(" " + treeNode.getValue());
        if (treeNode.getLeftNode() != null) {
            preorderTraversal(treeNode.getLeftNode());
        }
        if (treeNode.getRightNode() != null) {
            preorderTraversal(treeNode.getRightNode());
        }
    }

    /**
     * 中序遍历：先访问左子节点，再访问根节点，最后访问右子节点
     * @param treeNode 节点
     */
    private static void sequentialTraversal(TreeNode treeNode) {
        if (treeNode.getLeftNode() != null) {
            sequentialTraversal(treeNode.getLeftNode());
        }
        System.out.println(" " + treeNode.getValue());
        if (treeNode.getRightNode() != null) {
            sequentialTraversal(treeNode.getRightNode());
        }
    }

    /**
     * 后序遍历：先访问左子节点，再访问右子节点，最后访问根节点
     * @param treeNode 节点
     */
    private static void postOrderTraversal(TreeNode treeNode) {
        if (treeNode.getLeftNode() != null) {
            postOrderTraversal(treeNode.getLeftNode());
        }
        if (treeNode.getRightNode() != null) {
            postOrderTraversal(treeNode.getRightNode());
        }
        System.out.println(" " + treeNode.getValue());
    }
}