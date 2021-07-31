package com.nttdata.academy.service;

import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.ProdutoModel;

import java.util.Optional;

public interface ProdutoService {

    ProdutoModel adicionar(ProdutoModel produto);

    Optional<ProdutoModel> listar(Integer id);

    ProdutoModel atualizar(ProdutoModel produto, Integer id);

}
