package com.fish.steam;

import java.util.ArrayList;
import java.util.List;

public class TestObject {

    public void test() {

    }

    private void try_1() {
        List<TestObject> testObjectList = getList();
        testObjectList.forEach(testObject -> {
            String address = testObject.getAddress();

        });
    }

    private List<TestObject> getList() {
        List<TestObject> testObjectList = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            TestObject testObject = new TestObject();
            testObject.setId(i);
            testObject.setName("name_" + i);
            testObject.setAddress("address_" + i);
            testObjectList.add(testObject);
        }
        return testObjectList;
    }


    private String name;

    private int id;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
