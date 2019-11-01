package com.fish.design.model.create.bulid;

import java.math.BigDecimal;

public class SimpleBuilder {

    private Long id;

    private String name;

    private Byte type;

    private Double height;

    private Double width;

    private Double length;

    private BigDecimal price;

    public static class Builder {
        private Long id;

        private String name;

        private Byte type;

        private Double height;

        private Double width;

        private Double length;

        private BigDecimal price;

        public Builder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder typeBuilder(Byte type) {
            this.type = type;
            return this;
        }

        public Builder heightBuilder(Double height) {
            this.height = height;
            return this;
        }

        public Builder lengthBuilder(Double length) {
            this.length = length;
            return this;
        }

        public Builder widthBuilder(Double width) {
            this.width = width;
            return this;
        }

        public Builder priceBuilder(BigDecimal price) {
            this.price = price;
            return this;
        }

        public SimpleBuilder buildRealObject(Builder builder) {
            return new SimpleBuilder(builder);
        }
    }

    private SimpleBuilder(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.height = builder.height;
        this.width = builder.width;
        this.length = builder.length;
        this.price = builder.price;
    }
}
