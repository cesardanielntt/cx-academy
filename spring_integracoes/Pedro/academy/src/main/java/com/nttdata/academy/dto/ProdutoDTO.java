package com.nttdata.academy.dto;

public class ProdutoDTO {

    private Integer id;

    private String sku;

    private String nome;

    public Integer getId() {
        return id;
    }

    public ProdutoDTO() {
        this.id = id;
        this.sku = "";
        this.nome = "";
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
