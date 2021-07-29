package com.nttdata.academy.dto;


import java.io.Serializable;

public class PrecoDTO implements Serializable {

    private Integer id;

    private double valor;

    private String produto_id;

   private String cliente_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(String produto_id) {
        this.produto_id = produto_id;
    }

    public String getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(String cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public String toString() {
        return "PrecoDTO{" +
                "id=" + id +
                ", valor=" + valor +
                ", produto_id='" + produto_id + '\'' +
                ", cliente_id='" + cliente_id + '\'' +
                '}';
    }
}
