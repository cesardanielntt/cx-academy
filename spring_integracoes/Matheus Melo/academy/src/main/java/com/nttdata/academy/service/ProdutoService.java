package com.nttdata.academy.service;

import com.nttdata.academy.models.ProdutoModels;

import java.util.Optional;

public interface ProdutoService {

    ProdutoModels adicionar(ProdutoModels produto);

    Optional<ProdutoModels> listar(Integer id);

    ProdutoModels atualizar(ProdutoModels produto, Integer id);

    ProdutoModels deletar(Integer id);
}
