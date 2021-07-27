package com.nttdata.academy.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private Integer id;

    private Integer cpf;

    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", nome='" + nome + '\'' +
                '}';
    }
}
