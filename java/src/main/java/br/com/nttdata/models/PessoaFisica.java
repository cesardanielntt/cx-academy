package br.com.nttdata.models;

public class PessoaFisica extends Pessoa {
    private String sobrenome;
    private int idade;


<<<<<<< HEAD

=======
>>>>>>> master
    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String nomeCompleto(){
        return this.nome+" "+this.sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

<<<<<<< HEAD
}
=======

}
>>>>>>> master
