package com.nttdata.academy.models;



import javax.persistence.*;
import java.util.List;


@Entity
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidade;

    private Double total;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoModel produto;

    @ManyToOne(fetch = FetchType.LAZY)
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
        return "ItemModel{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", total=" + total +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", preco=" + preco +
                '}';
    }
}
