package com.nttdata.academy.dto;

import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.model.ProdutoModel;


public class ItemDTO {

    private Integer id;

    private Integer quantidade;

    private Double total;

    private ClienteDTO cliente;

    private ProdutoDTO produto;

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public PrecoDTO getPreco() {
        return preco;
    }

    public void setPreco(PrecoDTO preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", total=" + total +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", preco=" + preco +
                '}';
    }
}