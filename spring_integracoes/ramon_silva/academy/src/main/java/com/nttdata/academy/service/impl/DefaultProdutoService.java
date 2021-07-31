package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ProdutoRepository;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("produtoService")
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOG = LogManager.getLogger(ProdutoService.class);

    private ProdutoRepository produtoRepository;

    @Autowired
    public DefaultProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Optional<ProdutoModel> listar(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public ProdutoModel adicionar(ProdutoModel produto) {

        LOG.debug(produto);

        return produtoRepository.save(produto);
    }


    @Override
    public ProdutoModel atualizar(ProdutoModel produto, Integer id) {

        produto.setId(id);

        return produtoRepository.save(produto);
    }
}
