package com.fish.base.type;

import java.math.BigDecimal;

public class BigNumTest {



    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.239235");
        System.out.println(a.toString());
        System.out.println(a.setScale(3, BigDecimal.ROUND_UP).toString());

        BigDecimal b = a.setScale(3, BigDecimal.ROUND_HALF_UP);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
