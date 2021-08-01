package com.nttdata.academy.dto;



import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;


public class ItemDTO  implements Serializable {

    private Integer id;

    private Integer quantidade;

    private String total;

    @ManyToOne(fetch = FetchType.LAZY)
    private ClienteDTO cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProdutoDTO produto;

    @ManyToOne(fetch = FetchType.LAZY)
    private PrecoDTO preco;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClienteDTO> clientes;

    public List<ClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteDTO> clientes) {
        this.clientes = clientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public PrecoDTO getPreco() {
        return preco;
    }

    public void setPreco(PrecoDTO preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", total=" + total +
                ", cliente=" + cliente +
                ", produto=" + produto +
                ", preco=" + preco +
                '}';
    }

    public void setItens(List<ItemDTO> itensDTO) {
    }
}
