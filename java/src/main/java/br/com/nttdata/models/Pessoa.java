package br.com.nttdata.models;

public class Pessoa {
    private String nome;
    private String sobreNome;
    private String email;
    int idade;
    //private garante q as informações não sejam lidas só armazena

    public Pessoa(String nome){
        this.nome = nome;
    }

    //alt + insert > getter e setter - selecionar as linhas desejadas
    // para criar automaticamente as linhas abaixo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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

    //transformar os valores do objeto em string
    //permite vizualizar todos os dados de uma vez só
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
