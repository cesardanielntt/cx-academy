//package com.nttdata.spring.cxacademy.model;
//
//
//import javax.persistence.*;
//
//@Entity(name="Endereco")
//public class CustomerEndereco  {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer code;
//
//    @Column(nullable = false)
//    private String rua;
//
//    @Column(nullable = false)
//    private Integer numero;
//
//    @Column(nullable = false)
//    private String complemento;
//
//    @Column(nullable = false)
//    private String Cep;
//
//    @Column(nullable = false)
//    private String cidade;
//
//    @Column(nullable = false)
//    private String estado;
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public String getRua() {
//        return rua;
//    }
//
//    public void setRua(String rua) {
//        this.rua = rua;
//    }
//
//    public Integer getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
//
//    public String getComplemento() {
//        return complemento;
//    }
//
//    public void setComplemento(String complemento) {
//        this.complemento = complemento;
//    }
//
//    public String getCep() {
//        return Cep;
//    }
//
//    public void setCep(String cep) {
//        Cep = cep;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public String getEstado() {
//        return estado;
//    }
//
//    public void setEstado(String estado) {
//        this.estado = estado;
//    }
//}
