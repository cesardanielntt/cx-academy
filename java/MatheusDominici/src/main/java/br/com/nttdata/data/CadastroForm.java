package br.com.nttdata.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

public class CadastroForm {
    @FormParam("nome")
    @Size(min = 3, max = 25, message= "Nome Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String nome;

    @FormParam("sobrenome")
    @Size(min = 3, max = 25, message= "Sobrenome Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String sobrenome;

    @FormParam("email")
    @Email(message = "E-mail Inválido")
    @NotEmpty(message = "E-mail Obrigatório")
    private String email;

    @FormParam("idade")
    private int idade;

    @FormParam("rua")
    @Size(min = 3, max = 100, message= "Rua Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String rua;

    @FormParam("numero")
    private int numero;

    @FormParam("complemento")
    @Size(min = 3, max = 100, message= "Complemento Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String complemento;

    @FormParam("bairro")
    @Size(min = 3, max = 100, message= "Bairro Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String bairro;

    @FormParam("cidade")
    @Size(min = 3, max = 100, message= "Cidade Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String cidade;

    @FormParam("estado")
    @Size(min = 2, max = 2, message= "Estado Obrigatório")
    @NotEmpty(message = "Obrigatório")
    private String estado;

    @FormParam(".cep")
    private int cep;



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

    public String getRua() {return rua;}

    public void setRua(String rua) {this.rua = rua;}

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}

    public String getComplemento() {return complemento;}

    public void setComplemento(String complemento) {this.complemento = complemento;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public int getCep() {return cep;}

    public void setCep(int cep) {this.cep = cep;}

}
