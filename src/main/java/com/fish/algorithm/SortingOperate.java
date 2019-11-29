package com.fish.algorithm;

import com.fish.tool.JsonUtil;

import java.util.Arrays;

/**
 * 排序基础算法
 */
public class SortingOperate {
    public static void main(String[] args) {
        int[] array = {7, 2, 9, 3, 6, 2, 0, 5};
//        array = bubbleSort(array);
//        array = bubbleSortOptimization(array);
        array = selctionSort(array);
//        array = insertSort(array);
//        array = shellSort(array);
//        quicksort(array, 0, array.length - 1);
//        quicksort1(array, 0, array.length - 1);
//        mergeSort(array, 0, array.length - 1);
        System.out.println(JsonUtil.toJson(array));
    }

    /**
     * 冒泡排序
     * O(n2)
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
     * O(n2)
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
     * O(n2)
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
            for (int j = i + 1; j > 0; j--) {
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

    /**
     * 希尔排序
     * O(n1.5)
     *
     * @param array 待排序数组
     * @return 排序数组
     * <p>
     * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
     * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
     */
    public static int[] shellSort(int[] array) {

        int increase = array.length;
        while (true) {
            increase = increase / 2;

            // 按增长幅度循环，增长幅度相当于取数次数
            for (int i = 0; i < increase; i++) {
                // 循环一次取数的数组
                for (int j = i + increase; j < array.length; j += increase) {
                    // 执行插入排序 最后一个数字向前面的数组插入
                    for (int k = j; k > i; k -= increase) {
                        if (array[k] < array[k - increase]) {
                            int temp = array[k];
                            array[k] = array[k - increase];
                            array[k - increase] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }
            // 最后一次总体插入排序执行完毕后返回
            if (increase == 1) {
                break;
            }
        }
        return array;
    }

    /**
     * 快速排序算法
     * O(nlogn)
     * 算法思想：选出一个元素，将大于这个元素的数和小于这个元素的数分别挑选出来
     * 这就相当于在【原址】确定了该元素的位置
     * 再依次递归计算大于这个元素的数组和小于元素的数组最终确定所有元素的位置
     *
     * 总结：在执行循环时一定要选好一个移动标识，可选择一个记录标识配合。
     * 交换是原址排序都要采用的方法
     * 分治策略思想很重要：
     * 1. 分解 将问题分解成一些子问题，子问题的形式与原问题一样；
     * 2. 解决 递归的求解出子问题；
     * 3. 合并 将子问题的解组合成原问题的解
     * @param array 数组
     * @param p 数组开始
     * @param r 数组结束
     */
    public static void quicksort1(int[] array, int p, int r) {
        if (p < r) {
            int key = array[r];
            int i = p - 1;
            for (int j = p; j < r; j++) {
                if (array[j] < key) {
                    int temp = array[i + 1];
                    array[i + 1] = array[j];
                    array[j] = temp;
                    i++;
                }
            }
            int temp = array[i + 1];
            array[i + 1] = array[r];
            array[r] = temp;
            quicksort1(array, p, i);
            quicksort1(array, i + 2, r);
        }
    }
    /**
     * 快速排序
     *
     * 我的思路是两端向中间进发 两个标志位相同功能
     * 算法的思路是从一端出发，两个标志位不同功能，一个是大小分界指针，一个是循环计数指针
     *
     *
     *
     * @param array
     * @return
     */
    public static void quicksort(int[] array, int q, int r) {
        if (array == null || q >= r || q < 0 || r >= array.length) {
            return;
        }
        if (q == r - 1) {
            if (array[q] > array[r]) {
                int temp = array[r];
                array[r] = array[q];
                array[q] = temp;
            }
            return;
        }
        int key = array[r];
        int i = q;
        int j = r;
        while (i != j) {
            if (array[i] > key) {
                int temp = array[i];
                array[i] = array[j - 1];
                array[j - 1] = temp;
                j--;
            } else {
                i++;
            }
        }
        array[i + 1] = key;
        array[i + 1] = array[r];
        array[r] = key;
        quicksort(array, q, i);
        quicksort(array, i + 2, r);
    }

    /**
     * 归并排序
     * O(nlogn)
     *
     * 归并排序是典型的遵循分治法的算法
     * 1. 将数组分为两部分进行排序，再讲排序的两部分进行合并
     * 2. 递归操作1
     */
    public static void mergeSort(int[] array, int q, int r) {

        if (q < r) {
            int p = (q + r) / 2;

            mergeSort(array, q, p);
            mergeSort(array, p + 1, r);

            int leftLength = p - q + 1;
            int rightLength = r - p;

            int[] leftArray = Arrays.copyOfRange(array, q, p + 1);
            int[] rightArray = Arrays.copyOfRange(array, p + 1, r + 1);

            int leftKey = 0;
            int rightKey = 0;
            for (int i = q; i < (r + 1); i++) {
                if (leftKey < leftLength && rightKey < rightLength) {
                    if (leftArray[leftKey] > rightArray[rightKey]) {
                        array[i] = rightArray[rightKey];
                        rightKey++;
                        continue;
                    }
                    array[i] = leftArray[leftKey];
                    leftKey++;
                    continue;
                }
                if (leftKey < leftLength) {
                    array[i] = leftArray[leftKey];
                    leftKey++;
                    continue;
                }
                if (rightKey < rightLength) {
                    array[i] = rightArray[rightKey];
                    rightKey++;
                }
            }
        }
    }
}
