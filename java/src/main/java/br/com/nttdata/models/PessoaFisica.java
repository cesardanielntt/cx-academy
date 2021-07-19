package br.com.nttdata.models;

//classe pessoa fisica é uma extensão de Pessoa
public class PessoaFisica extends Pessoa {

    private String sobreNome;
    private int idade;

    //alt + insert
    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
