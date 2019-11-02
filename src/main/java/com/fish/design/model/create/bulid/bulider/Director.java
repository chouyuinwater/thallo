package com.fish.design.model.create.bulid.bulider;


import com.fish.design.model.create.bulid.product.Suit;

public class Director {

    private Bulider bulider;

    public void setBulider(Bulider bulider) {
        this.bulider = bulider;
    }

    public Suit constract() {


        return bulider.getSuit();
    }

}
