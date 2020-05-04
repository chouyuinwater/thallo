package com.fish.algorithm;

/**
 * 数组相关算法
 */
public class ArrayOperate {
    public static void main(String[] args) {
        orderedTwoDimensionalArrayLookup();

        orderedTwoDimensionalArrayInsertion();
    }

    /**
     * 第一题
     * 在一个二位数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的递增的顺序排序
     * 请完成一个函数，输入这样的一个二位数组和一个整数，判断数组中是否含有该整数
     *
     * 1 2 8 9
     * 2 4 9 12
     * 4 7 10 13
     * 6 8 11 15
     *
     * 思路：
     * 二维数组的行和列都是有序的，可以从数组中选取某个有边界功能的值来进行比较
     * 从而缩小查找范围。比如从右上角9开始比较，如果比9大则排除第一行，如果比9小则排除最后一列，
     * 以此循环寻找最终确定要查找的数字
     *
     * 总结
     * 当解决一个复杂问题是，一个很有效的办法就是从一个具体的为题入手，
     * 通过分析简单的具体例子，试图寻找普遍的规律。出自顺序数据使用排除法，缩小查找范围是一个常用思路。
     */
    private static void orderedTwoDimensionalArrayLookup() {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int key = 7;

        int height = array.length;
        int width = array[0].length;

        int indexWidth = 0;
        int indexHeight = height - 1;

        while (indexHeight >= 0 && indexWidth < width) {
            if (array[indexHeight][indexWidth] == key) {
                System.out.println("index = {" + indexHeight + "," + indexWidth + "}");
                return;
            }
            if (array[indexHeight][indexWidth] > key) {
                indexHeight--;
            } else {
                indexWidth++;
            }
        }
        System.out.println("key is not exist");
    }

    /**
     *
     * 第二题 替换空格相关题目
     * 有序数组插入
     *
     * 题目：有两个排序的数组A1 和 A2 内存在A1的末尾有足够的空余空间容纳A2.请事先一个函数，把A2的所有数字插入A1中
     * 并且所有的数字是排序的
     *
     * 思路：在合并两个数组包括字符串时，如果从前往后复制每个数字或字符则需要重复移动数字或字符多次（O(n^2)）,
     * 可以考虑从后往前复制，这样就能减少移动次数，从而提高效率。
     *
     * 总结：1. 在处理循环时可以考虑使用while来解决一些for循环解决不了的问题（本题中如果FOR循环数组A2则无法解决问题）
     *       2. 循环解决数组问题可以考虑从后向前循环解决问题，减少数组移动。
     *       3. 在一个数组内进行插入可以考虑从后向前。
     */
    private static void orderedTwoDimensionalArrayInsertion() {
//        int[] A1 = {1, 4, 6, 8, 9};
        int[] a1 = new int[11];
        a1[0] = 1;
        a1[1] = 4;
        a1[2] = 6;
        a1[3] = 8;
        a1[4] = 9;
        int[] a2 = {1, 3, 7, 7, 9, 10};

        int end = 5 + a2.length - 1;
        int indexA1 = 4;
        int indexA2 = a2.length - 1;
        while (indexA2 >= 0 && end >= 0 && indexA1>= 0) {
            if (a2[indexA2] >= a1[indexA1]) {
                a1[end] = a2[indexA2];
                indexA2--;
            } else {
                a1[end] = a1[indexA1];
                indexA1--;
            }
            end--;
        }
        for (int i = 0; i < a1.length ; i++) {
            System.out.println(a1[i]);
        }
    }

    /**
     * 求最大连续子数组
     *
     * 最大子数组问题的数组一定是包含负数的，否则最大连续子数组就是数组本身：）
     * 找出数组中间值
     * 比较中间值左面的最大子数组、跨越中间值的最大子数组、中间值右面的最大子数组谁大
     */
    private void maxSubArray() {

    }
}
