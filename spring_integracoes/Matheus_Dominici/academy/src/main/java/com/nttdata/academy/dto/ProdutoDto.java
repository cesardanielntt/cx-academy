package com.nttdata.academy.dto;

import java.io.Serializable;

public class ProdutoDto implements Serializable {
    private Integer id;
    private String sku;
    private String nome;

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getSku() {return sku;}

    public void setSku(String sku) {this.sku = sku;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    @Override
    public String toString() {
        return "ProdutoDto{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}