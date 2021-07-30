package com.nttdata.academy.models;

import javax.persistence.*;

@Entity
public class PrecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double valor;

    @OneToOne
    private ClienteModel cliente;

    @OneToOne
    private ProdutoModel produto;

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
