package br.com.nttdata.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.xml.transform.Source;

public class CadastroForm implements Source {
    @FormParam("nome")
    @Size(min = 3, max = 25, message = "O nome é obrigatorio!")
    private String nome;

    @FormParam("sobreNome")
    @Size(min = 3, max = 25, message = "O sobreNome é obrigatorio!")
    private String sobreNome;

    @FormParam("email")
    @Email(message = "email invalido!")
    @NotEmpty(message = "email é obrigatorio")
    private String email;

    @FormParam("idade")
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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

    @Override
    public void setSystemId(String systemId) {

    }

    @Override
    public String getSystemId() {
        return null;
    }
}
