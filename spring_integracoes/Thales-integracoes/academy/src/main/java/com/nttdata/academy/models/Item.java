package com.nttdata.academy.models;

public class Item {
    private Integer id;
    private Integer quantidade;
    private String total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", total='" + total + '\'' +
                '}';
    }
}
