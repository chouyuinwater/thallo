package com.fish.concurrent.product;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private Byte sex;
    private List<Person> parents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getId() != null ? !getId().equals(person.getId()) : person.getId() != null) return false;
        if (getName() != null ? !getName().equals(person.getName()) : person.getName() != null) return false;
        if (getAge() != null ? !getAge().equals(person.getAge()) : person.getAge() != null) return false;
        if (getAddress() != null ? !getAddress().equals(person.getAddress()) : person.getAddress() != null)
            return false;
        if (getSex() != null ? !getSex().equals(person.getSex()) : person.getSex() != null) return false;
        return getParents() != null ? getParents().equals(person.getParents()) : person.getParents() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getParents() != null ? getParents().hashCode() : 0);
        return result;
    }
}
