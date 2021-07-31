package com.nttdata.academy.dto;

import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.models.ProdutoModel;

public class ItemDto {
    private Integer id;
    private Integer quantidade;
    private Double total;
    private ClienteModel cliente;
    private ProdutoModel produto;
    private PrecoModel preco;

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModel produto) {
        this.produto = produto;
    }

    public PrecoModel getPreco() {
        return preco;
    }

    public void setPreco(PrecoModel preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", total=" + total +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", preco=" + preco +
                '}';
    }
}
