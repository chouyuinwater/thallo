package com.fish.algorithm;

/**
 * 排序基础算法
 */
public class SortingOperate {
    public static void main(String[] args) {
        int[] array = {7, 2, 9, 3, 6, 2, 0, 5};
        array = bubbleSort(array);
        array = bubbleSortOptimization(array);
//        array = selctionSort(array);
        array = insertSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 冒泡排序
     *
     * @param array 等待排序数组
     * @return 排序数组
     *
     * 注意:
     * 1. 相邻交换值！
     * 2. 冒泡顾名思义要从下往上推进，从尾部到头部
     * 比较相邻的两个数据，如果第二个数小，就交换位置。
     * 从后向前两两比较，一直到比较最前两个数据。
     * 最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
     * 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        return array;
    }

    /**
     * 冒泡排序优化
     *
     * @param array 等待排序数组
     * @return 排序数组
     *
     * 设置标志位flag，如果发生了交换flag设置为true；如果没有交换就设置为false。
     * 这样当一轮比较结束后如果flag仍为false，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
     */
    public static int[] bubbleSortOptimization(int[] array) {
        if (array == null) {
            return null;
        }
        boolean changeFlag;
        for (int i = 0; i < array.length - 1; i++) {
            changeFlag = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    changeFlag = true;
                }
            }
            if (!changeFlag) {
                System.out.println("OK");
                return array;
            }
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array 待排序数组
     * @return排序数组
     *
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     */
    public static int[] selctionSort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int indexMin = i;
                if (array[indexMin] > array[j]) {
                    indexMin = j;
                }
                if (indexMin != i) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;
    }

    /**
     * 插入排序
     *
     * @param array 待排序数组
     * @return 排序数组
     *
     * 在要排序的一组数中，假定前n-1个数已经排好序，
     * 现在将第n个数插到前面的有序数列中，
     * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     */
    public static int[] insertSort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    // 因为是有序数组
                    break;
                }
            }
        }
        return array;
    }
}
