package br.com.nttdata.models;

public class PessoaFisica extends Pessoa {
    private String sobrenome;
    private int idade;

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
/*
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero(){return numero; }
    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getComplemento() {return complemento;}
    public void  setComplemento(String complemento) {this.complemento = complemento; }

    public String getBairro() {return bairro;}
    public void  setBairro(String bairro) {this.bairro = bairro; }

    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade; }

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado; }

    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep; }*/
}
