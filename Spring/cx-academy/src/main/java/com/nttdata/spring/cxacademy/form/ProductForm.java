package com.nttdata.spring.cxacademy.form;

public class ProductForm {
    private Integer code;

    private String name;

    private String price;

    private boolean isAvailableOnline;

    public Integer getCode() {return code;}

    public void setCode(Integer code) {this.code = code;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;}

    public boolean isAvailableOnline() {return isAvailableOnline;}

    public void setAvailableOnline(boolean availableOnline) {isAvailableOnline = availableOnline;}
}
