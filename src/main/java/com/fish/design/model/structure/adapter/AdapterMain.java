package com.fish.design.model.structure.adapter;

import model.structure.adapter.impl.Adaptee;
import model.structure.adapter.impl.Adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdapterMain {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10 ; i++) {
            int randomCount = random.nextInt(100);
            integers.add(randomCount);
        }
        System.out.println(integers);
        integers = target.sort(integers);
        System.out.println(integers);
        int key = random.nextInt(10);
        System.out.println("find key : " + integers.get(key) + " in list");
        int index = target.search(integers, integers.get(key));
        System.out.println("index : " + index + " key : " + integers.get(index));
    }
}
