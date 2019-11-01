package com.fish.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestMain {


    /**
     * 重复利用lamda表达式
     * @param args
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a1");
        stringList.add("b1");
        stringList.add("b2");
        stringList.add("b3");
        stringList.add("b1");
        stringList.add("b2");
        stringList.add("b3");

        stringList = stringList.stream().distinct().collect(Collectors.toList());

        Consumer<String> consumer = o -> {
            System.out.println(o);
        };
        stringList.forEach(consumer);
    }
}
