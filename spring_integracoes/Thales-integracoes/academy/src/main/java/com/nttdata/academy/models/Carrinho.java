package com.nttdata.academy.models;

public class Carrinho {
    private Integer id;
    private String datahora;
    private String total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CarrinhoDTO{" +
                "id=" + id +
                ", datahora='" + datahora + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
