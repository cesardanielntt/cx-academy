package br.com.nttdata.models;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    //alt + insert
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
