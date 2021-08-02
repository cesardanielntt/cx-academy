package com.nttdata.academy.facade.impl;


import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;

import com.nttdata.academy.populator.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.LogManager;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoFacade.class);

    @Autowired
    private ProdutoPopulator produtoPopulator;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoDTO adicionar(ProdutoDTO produtoDTO){

        LOG.debug(produtoDTO);

        com.nttdata.academy.models.ProdutoModel produto = produtoPopulator.populateProdutoModel(produtoDTO);

       produto = produtoService.adicionar(produto);

        ProdutoDTO = produtoPopulator.populateProdutoDto(produto);

        return produtoDTO;
    }
}
