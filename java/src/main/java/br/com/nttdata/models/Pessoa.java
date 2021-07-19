package br.com.nttdata.models;

public class Pessoa {
    protected String id;
    private String nome;
    protected String email;

    //alt + insert
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

//public class Pessoa {
//    protected String id;
//    protected String email;

//    private String nome;
//    private String sobreNome;
//    private String email;
//    int idade;
//    //private: faz com que as informações não possam ser lidas, só armazenadas
//
//    public Pessoa(String nome){
//        this.nome = nome;
//    }
//
//    //alt + insert > getter e setter - selecionar as linhas desejadas
//    // para criar automaticamente as linhas abaixo
//    //converte os dados privados inseridos em um formato legivel
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getSobreNome() {
//        return sobreNome;
//    }
//
//    public void setSobreNome(String sobreNome) {
//        this.sobreNome = sobreNome;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getIdade() {
//        return idade;
//    }
//
//    public void setIdade(int idade) {
//        this.idade = idade;
//    }
//
//    //transformar os valores do objeto em string
//    //permite vizualizar todos os dados de uma vez só
//    @Override
//    public String toString() {
//        return "Pessoa{" +
//                "nome='" + nome + '\'' +
//                ", sobreNome='" + sobreNome + '\'' +
//                ", email='" + email + '\'' +
//                ", idade=" + idade +
//                '}';
//    }
//}
