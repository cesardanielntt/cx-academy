package com.nttdata.academy.service;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.stereotype.Service;

@Service("produtoService")
public interface ProdutoService {

    ProdutoModel adicionar(ProdutoModel produto);
}
