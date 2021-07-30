package com.nttdata.spring.cxacademy.form;

import com.nttdata.spring.cxacademy.model.AdressModel;

public class CustomerForm {

    private int code;
    private String name;
    private String sobrenome;
    private String email;
    private AdressForm endereco;

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

    public AdressForm getEndereco() {
        return endereco;
    }

    public void setEndereco(AdressForm endereco) {
        this.endereco = endereco;
    }
}
