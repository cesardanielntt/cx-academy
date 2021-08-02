package com.nttdata.academy.models;

import javax.persistence.*;

@Entity
public class ItemModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidade;

    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteModels cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoModels produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private PrecoModels preco;

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

    public ClienteModels getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModels cliente) {
        this.cliente = cliente;
    }

    public ProdutoModels getProduto() {
        return produto;
    }

    public void setProduto(ProdutoModels produto) {
        this.produto = produto;
    }

    public PrecoModels getPreco() {
        return preco;
    }

    public void setPreco(PrecoModels preco) {
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