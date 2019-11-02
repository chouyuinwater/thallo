package com.fish.design.model.structure.adapter.impl;

import com.fish.design.model.structure.adapter.Target;

import java.util.Arrays;
import java.util.List;

public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public List<Integer> sort(List<Integer> list) {
//        Integer[] a = list.toArray(new Integer[list.size()]);
//        int[] a = Stream.of(list).map(n -> n * n);
//        Integer[] a = list.stream().toArray(Integer[]::new);

        int[] a = Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Adapter::convertIntegerToIntStatic).toArray();
//        int[] a = list.stream().forEach(n -> n.intValue()).
//        Integer[] b = adaptee.sort(a);
        Integer[] b = Arrays.stream(adaptee.sort(a)).mapToObj(Integer::new).toArray(Integer[]::new);
        return Arrays.asList(b);
    }

    @Override
    public int search(List<Integer> list, int key) {
        int[] a = Arrays.stream(
                list.toArray(new Integer[list.size()])).mapToInt(Adapter::convertIntegerToIntStatic).toArray();

        int[] c = Arrays.stream(
                list.toArray(new Integer[list.size()])).mapToInt(n -> convertIntegerToInt(n)).toArray();
        return adaptee.search(a, key);
    }

    private static int convertIntegerToIntStatic(Integer n) {
        if (n == null) {
            return 0;
        }
        return n.intValue();
    }

    private int convertIntegerToInt(Integer n) {
        if (n == null) {
            return 0;
        }
        return n.intValue();
    }

//    public static void main(String[] args) {
//        Integer[] integers = new Integer[10];
//        int[] ints;
//        for (int i = 0; i < integers.length; i++) {
//            integers[i] = i;
//        }
//        ints= Arrays.stream(integers).mapToInt(n -> n).toArray();
//
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i]+"  ");
//        }
//    }
}
