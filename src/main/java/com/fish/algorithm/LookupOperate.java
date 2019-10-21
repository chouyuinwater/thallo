package com.fish.algorithm;

/**
 * 查找基础算法
 */
public class LookupOperate {

    public static void main(String[] args) {
        int[] array = {7, 2, 9, 3, 6, 2, 0, 5};

        SortingOperate.quicksort1(array, 0, array.length - 1);
        int index = binarySearch(array, 6, 0, array.length - 1);
        System.out.println("index = " + index);
    }

    /**
     * 二分查找
     * 时间复杂度O(logn)
     * 查找长度log(n+1)
     *
     * @param array 有序数组
     * @param key 查找数据
     * @param p 数组开始下标
     * @param r 数组结束下标
     * @return 查找数据下标 未查到为-1
     */
    public static int binarySearch(int[] array, int key, int p , int r) {
        if (array == null) {
            return -1;
        }
        if (p > r) {
            return -1;
        }
        int mid = (r + p) / 2;
        if (array[mid] == key) {
            return mid;
        }
        if (array[mid] > key) {
            return binarySearch(array, key, p, mid);
        }
        return binarySearch(array, key, mid + 1, r);
    }
}
