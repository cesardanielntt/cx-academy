package com.nttdata.academy.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<EnderecoModel> endereco;

    @OneToOne(mappedBy = "cliente")
    private CarrinhoModel carrinho;

    @OneToOne(mappedBy = "cliente")
    private PrecoModel preco;

    @OneToOne(mappedBy = "cliente")
    private ItemModel item;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<EnderecoModel> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.endereco = endereco;
    }

    public CarrinhoModel getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoModel carrinho) {
        this.carrinho = carrinho;
    }

    public PrecoModel getPreco() {
        return preco;
    }

    public void setPreco(PrecoModel preco) {
        this.preco = preco;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }
}
