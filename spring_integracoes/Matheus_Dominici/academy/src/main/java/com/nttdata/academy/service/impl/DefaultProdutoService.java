package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ProdutoRepository;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("produtoService")
public class DefaultProdutoService implements ProdutoService {
    private static Logger LOG = LogManager.getLogger(DefaultProdutoService.class);

    private ProdutoRepository produtoRepository;

    public DefaultProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoModel adicionar(ProdutoModel produto) {
        LOG.debug(produto);

        return produtoRepository.save(produto);
    }
}
