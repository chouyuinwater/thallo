package com.fish;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Gson gson = new Gson();
        List<String> strings = new ArrayList<>();
        strings.add("aaaa");
        System.out.println(gson.toJson(strings));
    }
}
