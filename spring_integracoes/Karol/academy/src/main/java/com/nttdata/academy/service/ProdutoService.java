package com.nttdata.academy.service;


import org.springframework.stereotype.Service;

@Service("produtoService")
public interface ProdutoService {

    com.nttdata.academy.models.ProdutoModel adicionar(com.nttdata.academy.models.ProdutoModel produto);
}
