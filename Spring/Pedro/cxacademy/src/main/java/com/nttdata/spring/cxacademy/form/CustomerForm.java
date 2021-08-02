package com.nttdata.spring.cxacademy.form;

import java.util.ArrayList;
import java.util.List;

public class CustomerForm {

    private int code;
    private String name;
    private String sobrenome;
    private String email;
    private List<AddressForm> enderecos;

    public CustomerForm() {
        this.enderecos = new ArrayList<>();
        AddressForm formVazio = new AddressForm();
        enderecos.add(formVazio);
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

    public List<AddressForm> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<AddressForm> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "CustomerForm{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +

                '}';
    }
}
