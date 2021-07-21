package br.com.nttdata.data;

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

    @FormParam("rua")
    @NotEmpty(message = "Rua obrigatória!")
    private String rua;

    @FormParam("numero")
    @Min(value = 1, message="Número obrigatório!")
    private String numero;

    @FormParam("complemento")
    private String complemento;

    @FormParam("bairro")
    @NotEmpty(message = "Bairro obrigatório!")
    private String bairro;

    @FormParam("cidade")
    @NotEmpty(message = "Cidade obrigatória!")
    private String cidade;

    @FormParam("estado")
    @NotEmpty(message = "Estado obrigatório!")
    private String estado;

    @FormParam("cep")
    @NotEmpty(message = "CEP obrigatório!")
    private String cep;

    @FormParam("idade")
    @Min(value = 1, message="Idade obrigatória!")
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
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

    @Override
    public String toString() {
        return "CadastroForm{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", idade=" + idade +
                '}';
    }
}