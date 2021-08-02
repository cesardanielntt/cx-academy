package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.ProdutoRepository;

import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("produtoService")
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoService.class);

    private ProdutoRepository produtoRepository;

    @Autowired
    public DefaultProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public com.nttdata.academy.models.ProdutoModel adicionar(com.nttdata.academy.models.ProdutoModel produto){

        LOG.debug(produto);

        return produtoRepository.save(produto);
    }

}
