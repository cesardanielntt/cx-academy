package com.nttdata.academy.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDTO implements Serializable {

    private Integer id;

    private String total;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDTO> itens = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDTO> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "CarrinhoDTO{" +
                "id=" + id +
                ", total=" + total +
                ", itens=" + itens +
                '}';
    }
}
