package com.fish.extent;

public class Father {
    private Father father;

    public Father() {
        System.out.println("father");
    }

    public void showFather() {
        father.showFather();
    }

    public void setFather(Father father) {
        this.father = father;
    }
}
