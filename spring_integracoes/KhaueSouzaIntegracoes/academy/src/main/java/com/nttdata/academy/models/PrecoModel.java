package com.nttdata.academy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "PrecoModel", indexes = {
        @Index(name = "idx_precomodel_cliente_id", columnList = "cliente_ID"),
        @Index(name = "idx_precomodel_produto_id", columnList = "produto_ID")
})
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
