package br.com.nttdata.models;

public class Endereco extends Pessoa {
    protected String rua;
    protected String numero;
    protected String complemento;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected String cep;

    public String getRua() { return rua; }

    public void setRua(String rua) { this.rua = rua; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }

    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getBairro() { return bairro; }

    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }

    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }
}
