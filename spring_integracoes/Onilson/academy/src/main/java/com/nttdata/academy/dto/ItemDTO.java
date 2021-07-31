package com.nttdata.academy.dto;



import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;


public class ItemDTO implements Serializable {

    private Integer id;

    private Integer quantidade;

    private Double total;

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
        return "ItemDTO{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", total=" + total +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", preco=" + preco +
                '}';
    }
}
