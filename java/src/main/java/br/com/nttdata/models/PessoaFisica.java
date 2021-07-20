package br.com.nttdata.models;

import br.com.nttdata.models.Pessoa;

public class PessoaFisica extends Pessoa {
    protected int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
