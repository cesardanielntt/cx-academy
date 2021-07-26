package com.nttdata.spring.cxacademy.model;

import javax.persistence.*;

//mapear o banco de dados
@Entity(name = "Product") //diz que a tabela se chama product
public class ProductModel {

    @Id//diz que o code vai ser a primary key
    @GeneratedValue (strategy = GenerationType.AUTO)//cria um id novo automaticamente
    private Integer code;
    //usar Integer ao invez de integer permite que a variavel possae ser nula


    @Column(nullable = false) //variavel não pode ser nulo
    private String name;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
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
