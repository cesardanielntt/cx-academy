package com.nttdata.academy.dto;

import com.nttdata.academy.models.EnderecoModel;

import java.io.Serializable;
import java.util.List;

public class ClienteDTO implements Serializable {

    private Integer id;

    private String cpf;

    private String nome;

    private List<EnderecoModel> enderecos;

//getter and setter
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EnderecoModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoModel> enderecos) {
        this.enderecos = enderecos;
    }

    // alt + insert > to string()

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", enderecos=" + enderecos +
                '}';
    }
}
