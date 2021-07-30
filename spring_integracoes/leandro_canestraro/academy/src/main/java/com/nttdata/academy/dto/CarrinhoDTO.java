package com.nttdata.academy.dto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDTO {

    private Integer id;

    private Double total;

    private List<ItemDTO> items = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}