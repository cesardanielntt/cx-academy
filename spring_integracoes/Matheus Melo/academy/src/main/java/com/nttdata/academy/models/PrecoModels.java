package com.nttdata.academy.models;

import javax.persistence.*;

@Entity
public class PrecoModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valor;

    @OneToOne
    private ClienteModels cliente;

    @OneToOne
    private ProdutoModels produto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Preco{" +
                "id=" + id +
                ", valor=" + valor +
                ", cliente=" + cliente +
                ", produto=" + produto +
                '}';
    }
}