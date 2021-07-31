package com.nttdata.academy.dto;

public class CarrinhoDto {
    private Integer id;
    private Double total;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CarrinhoDto{" +
                "id=" + id +
                ", total=" + total +
                '}';
    }
}
