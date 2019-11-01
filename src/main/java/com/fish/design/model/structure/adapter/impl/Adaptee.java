package com.fish.design.model.structure.adapter.impl;


public class Adaptee {

    public int[] sort(int[] a) {
        if (a == null) {
            // 不要null检查
            return new int[0];
        }
        // 降序
        // 直接插入排序
        for (int i = 1, length = a.length; i < length; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp <= a[j]) {
                    a[j + 1] = temp;
                    break;
                } else {
                    a[j + 1] = a[j];
                }
            }
            if (temp > a[0]) {
                a[0] = temp;
            }
        }
        return a;
    }

    public int search(int[] a, int k) {

        if (a == null || a.length == 0) {
            return -1;
        }
        return binarySearch(a, 0, a.length - 1, k);
    }

    private int binarySearch(int[] a, int left, int right, int k) {
        // 降序 二分查找
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (k < a[middle]) {
            return binarySearch(a, middle + 1, right, k);
        } else if (k > a[middle]) {
            return binarySearch(a, left, middle - 1, k);
        } else {
            return middle;
        }
    }
}
