package br.com.nttdata.models;

public class Pessoa {
    protected String name;
    protected String id;
    protected String email;
    protected Endereco address;

    public Pessoa() {
        address = new Endereco();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getAddress() {
        return address;
    }

}
