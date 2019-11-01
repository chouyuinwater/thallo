package com.fish.reflect.bean;

import java.io.Serializable;

public class Rule implements Serializable {

    private static final long serialVersionUID = -6839441910993503359L;
    private long code;
    private String name;
    private String codeName;
    private long sellerId;
    private String stationId;
    private String countryFrom;
    private String provinceFrom;
    private String cityFrom;
    private String countryTo;
    private String provinceTo;
    private String cityTo;
    private int weight;
    private int valueMin;
    private int valueMax;
    private boolean isRight;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public long getSellerId() {
        return sellerId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(String countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getProvinceFrom() {
        return provinceFrom;
    }

    public void setProvinceFrom(String provinceFrom) {
        this.provinceFrom = provinceFrom;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(String countryTo) {
        this.countryTo = countryTo;
    }

    public String getProvinceTo() {
        return provinceTo;
    }

    public void setProvinceTo(String provinceTo) {
        this.provinceTo = provinceTo;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValueMin() {
        return valueMin;
    }

    public void setValueMin(int valueMin) {
        this.valueMin = valueMin;
    }

    public int getValueMax() {
        return valueMax;
    }

    public void setValueMax(int valueMax) {
        this.valueMax = valueMax;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", codeName='" + codeName + '\'' +
                ", sellerId=" + sellerId +
                ", stationId='" + stationId + '\'' +
                ", countryFrom='" + countryFrom + '\'' +
                ", provinceFrom='" + provinceFrom + '\'' +
                ", cityFrom='" + cityFrom + '\'' +
                ", countryTo='" + countryTo + '\'' +
                ", provinceTo='" + provinceTo + '\'' +
                ", cityTo='" + cityTo + '\'' +
                ", weight=" + weight +
                ", valueMin=" + valueMin +
                ", valueMax=" + valueMax +
                ", isRight=" + isRight +
                '}';
    }
}
