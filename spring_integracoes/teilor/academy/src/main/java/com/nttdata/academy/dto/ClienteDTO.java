package com.nttdata.academy.dto;

import java.io.Serializable;
import java.util.List;

public class ClienteDTO extends MessageDTO implements Serializable {

    private Integer id;

    private String cpf;

    private String nome;

    private List<EnderecoDTO> enderecos;

    public ClienteDTO() {
    }

    public ClienteDTO(String message, int status) {
        super(message, status);
    }

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

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }

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
