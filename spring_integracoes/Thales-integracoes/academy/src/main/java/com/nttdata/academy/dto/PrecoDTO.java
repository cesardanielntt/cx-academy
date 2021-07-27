package com.nttdata.academy.dto;

public class PrecoDTO {
    private Integer id;
    private String preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "PrecoDTO{" +
                "id=" + id +
                ", preco='" + preco + '\'' +
                '}';
    }
}
