package com.nttdata.spring.cxacademy.data;

import com.nttdata.spring.cxacademy.form.AddressForm;

import java.util.List;

public class CustomerData {

    private int code;
    private String name;
    private String sobrenome;
    private String email;
    private List<AddressData> enderecos;



    public Integer getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public List<AddressData> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<AddressData> enderecos) {
        this.enderecos = enderecos;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", enderecos=" + enderecos +
                '}';
    }
}
