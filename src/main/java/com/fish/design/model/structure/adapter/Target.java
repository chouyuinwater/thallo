package com.fish.design.model.structure.adapter;

import java.util.List;

public interface Target {

    List<Integer> sort(List<Integer> list);

    int search(List<Integer> list, int key);
}
