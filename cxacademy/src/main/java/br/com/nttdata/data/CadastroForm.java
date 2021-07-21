package br.com.nttdata.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

public class CadastroForm {

    @FormParam("name")
    @Size(min = 3, max = 25, message = "Invalid Name")
    private String name;

    @FormParam("last-name")
    @Size(min = 3, max = 25, message = "Invalid Last Name")
    private String lastName;

    @FormParam("age")
//    @NotNull(message = "Required Field")
    private Integer age;

    @FormParam("email")
    @Email(message = "Invalid Email!")
    @NotEmpty(message = "Required Field")
    private String email;

    @FormParam("street")
    @NotEmpty(message = "Required Field")
    private String street;

    @FormParam("number")
    @NotEmpty(message = "Required Field")
    private String number;

    @FormParam("complement")
    @NotEmpty(message = "Required Field")
    private String complement;

    @FormParam("district")
    @NotEmpty(message = "Required Field")
    private String district;

    @FormParam("city")
    @NotEmpty(message = "Required Field")
    private String city;

    @FormParam("state")
    @NotEmpty(message = "Required Field")
    private String state;

    @FormParam("cep")
    @Size(min = 8, message = "Invalid CEP")
    private String cep;


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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
