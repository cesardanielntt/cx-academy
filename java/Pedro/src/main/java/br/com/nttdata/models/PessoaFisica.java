package br.com.nttdata.models;

public class PessoaFisica extends Pessoa{
    private String sobrenome;
    private int idade;

    public PessoaFisica(){
        endereco = new Endereco();
    }

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
}
