package br.com.nttdata.data;

<<<<<<< HEAD
=======
import br.com.nttdata.service.PessoaService;

>>>>>>> master
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

public class CadastroForm {

<<<<<<< HEAD
    @FormParam("nome")
    @Size(min = 3, max = 25, message = "O nome é obrigatório!")
    private String nome;

    @FormParam("sobrenome")
    @Size(min = 3, max = 25, message = "O sobrenome é obrigatório!")
    private String sobrenome;

    @FormParam("email")
    @Email(message = "E-mail inválido!")
    @NotEmpty(message = "E-mail obrigatório!")
=======

    @FormParam("nome")
    @Size(min = 3, max = 25, message = "O nome é obrigatório")
    private String nome;

    @FormParam("sobrenome")
    @Size(min = 3, max = 25, message = "O nome é obrigatório")
    private String sobrenome;

    @FormParam("email")
    @Email (message = "E-mail inválido")
    @NotEmpty(message = "E-mail obrigatório")
>>>>>>> master
    private String email;

    @FormParam("idade")
    private int idade;

    @FormParam("rua")
<<<<<<< HEAD
    @NotEmpty(message = "O endereço é obrigatório!")
=======
    @Size(min = 3, max = 50, message = "A rua é obrigatório")
>>>>>>> master
    private String rua;

    @FormParam("numero")
    private int numero;

    @FormParam("complemento")
<<<<<<< HEAD
    private String complemento;

    @FormParam("bairro")
    @NotEmpty(message = "Informar o bairro é obrigatório!")
    private String bairro;

    @FormParam("cidade")
    @NotEmpty(message = "Informar a Cidade é obrigatório!")
    private String cidade;

    @FormParam("estado")
    @NotEmpty(message = "Informar o Estado obrigatório!")
    private String estado;

    @FormParam("cep")
    private int cep;

    public String getNome() {
=======
    @Size(min = 3, max = 50, message = "O complemento é obrigatório")
    private String complemento;

    @FormParam("bairro")
    @Size(min = 3, max = 50, message = "O bairro é obrigatório")
    private String bairro;

    @FormParam("cidade")
    @Size(min = 3, max = 50, message = "A cidade é obrigatório")
    private String cidade;

    @FormParam("estado")
    @Size(min = 3, max = 50, message = "O estado é obrigatório")
    private String estado;

    @FormParam("cep")
    private String cep;




    public String getNome() {

>>>>>>> master
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
<<<<<<< HEAD
=======

>>>>>>> master
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
<<<<<<< HEAD
=======

>>>>>>> master
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
<<<<<<< HEAD
=======

>>>>>>> master
        return idade;
    }

    public void setIdade(int idade) {
<<<<<<< HEAD
=======

>>>>>>> master
        this.idade = idade;
    }

    public String getRua() {
<<<<<<< HEAD
=======

>>>>>>> master
        return rua;
    }

    public void setRua(String rua) {
<<<<<<< HEAD
=======

>>>>>>> master
        this.rua = rua;
    }

    public int getNumero() {
<<<<<<< HEAD
=======

>>>>>>> master
        return numero;
    }

    public void setNumero(int numero) {
<<<<<<< HEAD
=======

>>>>>>> master
        this.numero = numero;
    }

    public String getComplemento() {
<<<<<<< HEAD
=======

>>>>>>> master
        return complemento;
    }

    public void setComplemento(String complemento) {
<<<<<<< HEAD
=======

>>>>>>> master
        this.complemento = complemento;
    }

    public String getBairro() {
<<<<<<< HEAD
=======

>>>>>>> master
        return bairro;
    }

    public void setBairro(String bairro) {
<<<<<<< HEAD
=======

>>>>>>> master
        this.bairro = bairro;
    }

    public String getCidade() {
<<<<<<< HEAD
=======

>>>>>>> master
        return cidade;
    }

    public void setCidade(String cidade) {
<<<<<<< HEAD
=======

>>>>>>> master
        this.cidade = cidade;
    }

    public String getEstado() {
<<<<<<< HEAD
=======

>>>>>>> master
        return estado;
    }

    public void setEstado(String estado) {
<<<<<<< HEAD
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

//    @Override
//    public String toString() {
//        return "CadastroForm{" +
//                "nome='" + nome + '\'' +
//                ", sobrenome='" + sobrenome + '\'' +
//                ", email='" + email + '\'' +
//                ", idade=" + idade +
//                ", rua='" + rua + '\'' +
//                ", numero=" + numero +
//                ", complemento='" + complemento + '\'' +
//                ", bairro='" + bairro + '\'' +
//                ", cidade='" + cidade + '\'' +
//                ", estado='" + estado + '\'' +
//                ", cep=" + cep +
//                '}';
//    }
}
=======

        this.estado = estado;
    }

    public String getCep() {

        return cep;
    }

    public void setCep(String cep) {

        this.cep = cep;
    }
}
>>>>>>> master
