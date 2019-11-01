package com.fish.base.list;

import java.math.BigDecimal;

public class ListBean {
    private Long id;
    private String name;
    private BigDecimal price;
    private Integer code;
    private Double value;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", code=" + code +
                ", value=" + value +
                '}';
    }
}
