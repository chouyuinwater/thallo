package com.fish.collection;

import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>(6,1);
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.put("f", 6);
        map.get("");
        System.out.println(map);
    }
}
