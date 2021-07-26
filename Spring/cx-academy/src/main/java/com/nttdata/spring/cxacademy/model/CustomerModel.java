package com.nttdata.spring.cxacademy.model;


import javax.persistence.*;

@Entity(name = "Customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cod;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    @Column(nullable = false)
    private String complemento;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;


    public Integer getCod() {return cod;}

    public void setCod(Integer cod) {this.cod = cod;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSobrenome() {return sobrenome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getRua() {return rua;}

    public void setRua(String rua) {this.rua = rua;}

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}

    public String getComplemento() {return complemento;}

    public void setComplemento(String complemento) {this.complemento = complemento;}

    public String getCep() {return cep;}

    public void setCep(String cep) {this.cep = cep;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}
}
