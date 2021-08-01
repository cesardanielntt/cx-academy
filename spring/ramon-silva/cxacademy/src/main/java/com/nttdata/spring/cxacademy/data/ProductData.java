package com.nttdata.spring.cxacademy.data;

public class ProductData {

    private Integer code;
    private String name;
    private String price;
    private boolean avaliableOnline;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isAvaliableOnline() {
        return avaliableOnline;
    }

    public void setAvaliableOnline(boolean avaliableOnline) {
        this.avaliableOnline = avaliableOnline;
    }
}
