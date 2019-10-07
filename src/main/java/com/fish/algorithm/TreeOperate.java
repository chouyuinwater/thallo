package com.fish.algorithm;

import com.fish.algorithm.vo.TreeNode;

import java.lang.reflect.Array;
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

    }

    /**
     * 第7题
     * 重建二叉树
     * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
     * 假设输入的前序遍历和中序遍历的结果都不含重复的的数字
     * 例如：输入前序遍历数列{1, 2, 4, 7, 3, 5, 6, 8}
     * 和中序遍历数列{4, 7, 2, 1, 5, 3, 8, 6}, 则重建二叉树
     * 树节点定义为TreeNode
     */
    private static void reconstructingBinaryTree() {
        int[] q = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] z = {4, 7, 2, 1, 5, 3, 8, 6};


    }

    private static TreeNode setTree(int[] q, int[] z) {
        TreeNode rootTreeNode = new TreeNode();
        TreeNode leftTreeNode = new TreeNode();
        TreeNode rightTreeNode = new TreeNode();

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

//        Arrays.copyOf();

        return rootTreeNode;
    }
}