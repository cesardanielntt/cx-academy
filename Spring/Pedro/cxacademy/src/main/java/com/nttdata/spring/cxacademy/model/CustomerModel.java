package com.nttdata.spring.cxacademy.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Customer")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AddressModel> enderecos;

    public CustomerModel() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressModel> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<AddressModel> enderecos) {
        this.enderecos = enderecos;
    }
}
