package com.nttdata.academy.dto;



import javax.persistence.OneToOne;
import java.io.Serializable;

public class PrecoDTO implements Serializable {


    private Integer id;

    private double valor;

    @OneToOne
    private ClienteDTO clienteDTO;

    @OneToOne
    private ProdutoDTO produtoDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public ProdutoDTO getProdutoDTO() {
        return produtoDTO;
    }

    public void setProdutoDTO(ProdutoDTO produtoDTO) {
        this.produtoDTO = produtoDTO;
    }

    @Override
    public String toString() {
        return "PrecoDTO{" +
                "id=" + id +
                ", valor=" + valor +
                ", clienteDTO=" + clienteDTO +
                ", produtoDTO=" + produtoDTO +
                '}';
    }
}
