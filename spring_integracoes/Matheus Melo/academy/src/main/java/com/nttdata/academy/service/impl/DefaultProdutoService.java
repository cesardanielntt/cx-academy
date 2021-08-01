package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ProdutoRepositoryDao;
import com.nttdata.academy.models.ProdutoModels;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ProdutoService")
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOG = LogManager.getLogger(ProdutoService.class);

    private ProdutoRepositoryDao produtoRepositoryDao;

    @Autowired
    public DefaultProdutoService(ProdutoRepositoryDao produtoRepositoryDao) {
        this.produtoRepositoryDao = produtoRepositoryDao;
    }

    @Override
    public ProdutoModels adicionar(ProdutoModels produto) {
        LOG.debug(produto);
        return produtoRepositoryDao.save(produto);
    }

    @Override
    public Optional<ProdutoModels> listar(Integer id) {
        return produtoRepositoryDao.findById(id);
    }

    @Override
    public ProdutoModels atualizar(ProdutoModels produto, Integer id) {
        produto.setId(id);
        return produtoRepositoryDao.save(produto);
    }

    @Override
    public ProdutoModels deletar(Integer id) {
        produtoRepositoryDao.deleteById(id);
        return null;
    }
}
