package com.nttdata.spring.cxacademy.form;

public class CustomerForm{
    private Integer cod;
    private String nome;
    private String sobrenome;
    private String email;
    private String rua;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;


    public Integer getCod() {return cod;}

    public void setCod(Integer cod) {this.cod = cod;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSobrenome() {return sobrenome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
