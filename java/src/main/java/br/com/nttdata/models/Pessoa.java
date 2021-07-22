package br.com.nttdata.models;
import java.lang.Integer;

public class Pessoa {
    protected String id;
    protected String nome;
    protected String email;
    protected String rua;
    protected int numero;
    protected String complemento;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected int cep;


    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public int getNumero() { return numero; }

    public void setNumero(int numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public int getCep() { return cep; }

    public void setCep(int cep) { this.cep = cep; }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
