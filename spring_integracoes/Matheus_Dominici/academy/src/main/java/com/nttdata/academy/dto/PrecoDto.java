package com.nttdata.academy.dto;

public class PrecoDto {
    private Integer id;
    private Double valor;

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

    @Override
    public String toString() {
        return "PrecoDto{" +
                "id=" + id +
                ", valor=" + valor +
                '}';
    }
}
