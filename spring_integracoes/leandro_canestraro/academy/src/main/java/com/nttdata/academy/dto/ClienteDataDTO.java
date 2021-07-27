package com.nttdata.academy.dto;

import java.io.Serializable;

public class ClienteDataDTO implements Serializable {

    private Integer id;
    private String cpf;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClienteDataDTO{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
