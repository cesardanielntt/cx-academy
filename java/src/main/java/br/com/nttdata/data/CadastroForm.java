package br.com.nttdata.data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.validation.constraints.Email;


public class CadastroForm {

    @FormParam("nome")
    @Size (min =3, max =25, message = "O nome é obrigatório")
    private String nome;


    @FormParam("sobrenome")
    @Size (min =3, max =25, message = "O sobrenome é obrigatório")
    private String sobrenome;

    @FormParam("idade")
    private int idade;


    @FormParam("email")
    @Email(message = "E-mail inválido")
    @NotEmpty(message = "E-mail obrigatório")
    private String email;



    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
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


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }
}
