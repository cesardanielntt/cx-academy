package com.nttdata.spring.cxacademy.model;


import javax.persistence.*;


@Entity(name = "Product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private boolean availableOnline;


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

    public boolean isAvailableOnline() {
        return availableOnline;
    }

    public void setAvailableOnline(boolean availableOnline) {
        this.availableOnline = availableOnline;
    }
}
