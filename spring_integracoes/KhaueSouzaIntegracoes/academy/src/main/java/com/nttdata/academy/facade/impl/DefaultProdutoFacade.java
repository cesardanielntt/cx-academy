package com.nttdata.academy.facade.impl;


import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import org.springframework.stereotype.Service;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    @Override
    public void adicionar(ProdutoDTO produto) {

    }
}
