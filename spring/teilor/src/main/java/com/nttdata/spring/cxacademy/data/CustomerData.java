package com.nttdata.spring.cxacademy.data;

import java.util.List;

public class CustomerData {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private List<AddressData> addresses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressData> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressData> addresses) {
        this.addresses = addresses;
    }
}
