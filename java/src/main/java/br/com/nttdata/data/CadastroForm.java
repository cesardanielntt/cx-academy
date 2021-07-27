package br.com.nttdata.data;

import javax.ws.rs.FormParam;

public class CadastroForm {

    @FormParam("nome")
    private String nome;

    @FormParam("sobrenome")
    private String sobrenome;

    @FormParam("email")
    private String email;

    @FormParam("idade")
    private int idade;

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

