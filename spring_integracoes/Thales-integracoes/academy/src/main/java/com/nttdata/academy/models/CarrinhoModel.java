package com.nttdata.academy.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class CarrinhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double total;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> items = new ArrayList<>();

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

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
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

    public void setMessage(String s) {
    }

    public void setCliente(CarrinhoModel carrinho) {
    }
}

