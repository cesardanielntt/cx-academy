package br.com.nttdata.data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @Size (min =2, max =3, message = "A idade é obrigatória")
    private String idade;


    @FormParam("email")
    @Email(message = "E-mail inválido")
    @NotEmpty(message = "E-mail obrigatório")
    private String email;

    @FormParam("rua")
    @Size (min =3, max =25, message = "A rua é obrigatório")
    private String rua;

    @FormParam("numero")
    @Size (min =1, max =25, message = "O número é obrigatório")
    private String numero;

    @FormParam("complemento")
    @Size (min =2, max =25, message = "O complemento é obrigatório")
    private String complemento;

    @FormParam("bairro")
    @NotNull(message = "O bairro é obrigatório")
    private String bairro;

    @FormParam("cidade")
    @Size (min =3, max =25, message = "A cidade é obrigatório")
    private String cidade;

    @FormParam("estado")
    @Size (min =3, max =25, message = "O estado é obrigatório")
    private String estado;

    @FormParam("cep")
    @Size (min =3, max =25, message = "O CEP é obrigatório")
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




    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
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

}
