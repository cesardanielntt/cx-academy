package com.nttdata.academy.dto;

public class PrecoDTO {

    private Integer id;
    private Double valor;
    private Integer idCliente;
    private Integer idProduto;

    public PrecoDTO() {
        this.valor = 0.0;
    }

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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return "PrecoDTO{" +
                "id=" + id +
                ", valor=" + valor +
                ", idCliente=" + idCliente +
                ", idProduto=" + idProduto +
                '}';
    }
}
