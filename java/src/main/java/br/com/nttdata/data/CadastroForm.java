package br.com.nttdata.data;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;

public class CadastroForm {

    @FormParam("nome")
    @Size(min = 3, max = 25, message = "O nome é obrigatório!")
    private String nome;

    @FormParam("sobrenome")
    @Size(min = 3, max = 25, message = "O sobrenome é obrigatório!")
    private String sobrenome;

    @FormParam("email")
    @Email(message = "E-mail inválido!")
    @NotEmpty(message = "E-mail obrigatório!")
    private String email;

    @FormParam("idade")
    @Min(1)
    private int idade;

    @FormParam("rua")
    @NotEmpty(message = "Rua obrigatório!")
    private String rua;

    @FormParam("numero")
    @Min(1)
    private int numero;

    @FormParam("complemento")
    @NotEmpty(message = "Complemento obrigatório!")
    private String complemento;

    @FormParam("bairro")
    @NotEmpty(message = "Bairro obrigatório!")
    private String bairro;

    @FormParam("cidade")
    @NotEmpty(message = "Cidade obrigatório!")
    private String cidade;

    @FormParam("estado")
    @NotEmpty(message = "Estado obrigatório!")
    private String estado;

    @FormParam("cep")
    @Size (min =1, max =8, message = "O CEP é obrigatório")
    private String cep;


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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
