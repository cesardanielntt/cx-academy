package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ProdutoRepository;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("produtoService")
public class DefaultProdutoService implements ProdutoService {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoService.class);

    private ProdutoRepository produtoRepository;

    @Autowired
    public DefaultProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoModel adicionar(ProdutoModel produto) {

        LOG.debug(produto);
        System.out.println("Adicionando produto ao banco...");
        return produtoRepository.save(produto);

    }

    public void atualizar(ProdutoModel produto, Integer id){

        System.out.println("Atualizando produto...");

        produto.setId(id);

        produtoRepository.save(produto);
    }

    @Override
    public List<ProdutoModel> listar(){

        System.out.println("Pegando os produtos do banco...");

        return produtoRepository.findAll();

    }

    @Override
    public List<ProdutoModel> consultar(Integer id) {

        System.out.println("Pegando os produtos do banco...");

        return produtoRepository.findAllById(Collections.singleton(id));

    }

    @Override
    public void deletar(Integer id){

        produtoRepository.removeProdutoModelById(id);
    }

}
