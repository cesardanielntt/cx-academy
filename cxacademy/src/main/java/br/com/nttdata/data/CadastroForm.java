package br.com.nttdata.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
    private Integer age;

    @FormParam("email")
    @Email(message = "Invalid Email!")
    @NotEmpty(message = "Required Field")
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
