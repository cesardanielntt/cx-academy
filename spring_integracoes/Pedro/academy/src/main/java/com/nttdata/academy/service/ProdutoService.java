package com.nttdata.academy.service;

import com.nttdata.academy.models.ProdutoModel;

import java.util.List;

public interface ProdutoService {

    ProdutoModel adicionar(ProdutoModel produto);

    void atualizar(ProdutoModel produto, Integer id);

    public List<ProdutoModel> consultar(Integer id);

    public List<ProdutoModel> listar();

    public void deletar(Integer id);

}
