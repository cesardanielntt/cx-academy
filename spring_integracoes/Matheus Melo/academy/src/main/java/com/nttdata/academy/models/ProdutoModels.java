package com.nttdata.academy.models;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

@Entity
public class ProdutoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String sku;

    private String nome;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ItemModels> items;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PrecoModels> precos;

    public Integer getId() {
        return id;
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

    public List<ItemModels> getItems() {
        return items;
    }

    public void setItems(List<ItemModels> items) {
        this.items = items;
    }

    public List<PrecoModels> getPrecos() {
        return precos;
    }

    public void setPrecos(List<PrecoModels> precos) {
        this.precos = precos;
    }
}