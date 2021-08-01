package com.nttdata.academy.dto;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

public class ItemDTO {
    private Integer id;
    private Integer quantidade;
    private String total;
    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteDTO cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoDTO produto;
    @ManyToOne(fetch = FetchType.LAZY)
    private PrecoDTO preco;


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

    public void setItens(List<ItemDTO> itensDTO) { }

    public ItemDTO() {
        this.cliente = cliente;
        this.produto = produto;
        this.preco = preco;
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
