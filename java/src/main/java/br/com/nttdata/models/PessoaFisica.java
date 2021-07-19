package br.com.nttdata.models;

public class PessoaFisica extends Pessoa {
    private int idade;
    private String sobrenome;


    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
       return idade;
    }

    public int setIdade( idade) {
        this.idade = idade;
    }

}
