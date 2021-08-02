package com.nttdata.academy.dto;

public class ItemDTO {

    private Integer id;

    private Integer quantidade;

    private Double total;

    private Integer clienteId;

    private Integer produtoId;

    private Integer precoId;

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

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getPrecoId() {
        return precoId;
    }

    public void setPrecoId(Integer precoId) {
        this.precoId = precoId;
    }
}
