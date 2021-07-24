package br.com.nttdata.models;

<<<<<<< HEAD
//classe pessoa fisica é uma extensão de Pessoa
public class PessoaFisica extends Pessoa {

    private String sobreNome;
    private int idade;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    //alt + insert

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

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
=======
public class PessoaFisica extends Pessoa {
    private String sobrenome;
    private int idade;


    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String nomeCompleto(){
        return this.nome+" "+this.sobrenome;
>>>>>>> origin/master
    }

    public int getIdade() {
        return idade;
    }

<<<<<<< HEAD
    public void setIdade(int idade) { this.idade = idade; }
=======
    public void setIdade(int idade) {
        this.idade = idade;
    }
>>>>>>> origin/master
}
