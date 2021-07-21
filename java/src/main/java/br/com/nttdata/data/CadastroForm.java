package br.com.nttdata.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    private int idade;

    @FormParam("rua")
    @Size(min = 7, max = 40, message = "A rua é Obrigatória!")
    private String rua;

    @FormParam("numero")
    private int numero;

    @FormParam("complemento")
    @Size(min = 3, max = 30, message = "O complemento é Obrigatório!")
    private String complemento;

    @FormParam("bairro")
    @Size(min = 5, max = 40, message = "O bairro é Obrigatório!")
    private String bairro;

    @FormParam("cidade")
    @Size(min = 3, max = 40, message = "A cidade é Obrigatória!")
    private String cidade;

    @FormParam("estado")
    @Size(min = 3, max = 30, message = "O estado é Obrigatório!")
    private String estado;

    @FormParam("cep")
    @Size(min = 3, max = 30, message = "O cep é Obrigatório!")
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

    @Override
    public String toString() {
        return "CadastroForm{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
