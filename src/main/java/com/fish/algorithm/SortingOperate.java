package com.fish.algorithm;

/**
 * 排序基础算法
 */
public class SortingOperate {
    public static void main(String[] args) {
        int[] array = {7, 2, 9, 3, 6, 2, 0, 5};
        array = bubbleSort(array);



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
     * 比较相邻的两个数据，如果第二个数小，就交换位置。
     * 从后向前两两比较，一直到比较最前两个数据。
     * 最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
     * 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null) {
            return null;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
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
        for (int i = 0; i < array.length; i++) {
            changeFlag = false;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    changeFlag = true;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            // 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
            if (!changeFlag) {
                break;
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array 待排序数组
     * @return 排序数组
     */
    public static int[] insertSort(int[] array, int length) {
        if (array == null) {
            return null;
        }

        if (length == 2) {

        }
        return array;
    }
}
