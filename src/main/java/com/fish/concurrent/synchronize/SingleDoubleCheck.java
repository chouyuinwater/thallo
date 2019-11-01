package com.fish.concurrent.synchronize;


import com.fish.concurrent.product.Person;

public class SingleDoubleCheck {
    private static volatile Person person;

    public static Person getInstance() {
        if (person == null) {
            synchronized ("") {
                if (person == null) {
                    person = new Person();
                }
            }
        }
        return person;
    }


    private class Node {

    }

    public static class NewNode {
        private String a;
        private int b;
        private boolean c;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public boolean isC() {
            return c;
        }

        public void setC(boolean c) {
            this.c = c;
        }
    }




}
