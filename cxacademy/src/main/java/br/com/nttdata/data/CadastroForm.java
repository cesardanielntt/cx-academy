package br.com.nttdata.data;

import javax.ws.rs.FormParam;

public class CadastroForm {

    @FormParam("name")
    private String name;

    @FormParam("last-name")
    private String lastName;

    @FormParam("age")
    private Integer age;

    @FormParam("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
