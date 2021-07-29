package com.nttdata.academy.dto;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.model.ProdutoModel;

public class PrecoDTO {

    private Integer id;

    private Double valor;

    private ClienteDTO cliente;

    private ProdutoDTO produto;

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