package com.nttdata.academy.service.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoService.class);

    @Override
    public void adicionar(ProdutoDTO produto) {
        LOG.debug(produto);
    }
}
