package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoFacade.class);

    @Autowired
    private ProdutoPopulator produtoPopulator;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ResponseEntity adicionar(ProdutoDTO produtoDTO) {

        //LOG.debug(produtoDTO);

        ProdutoModel produto = produtoPopulator.populateProdutoModel(produtoDTO);

        produto = produtoService.adicionar(produto);

        System.out.println("Id do produto: " + produto.getId());

        produtoDTO = produtoPopulator.populateProdutoDto(produto);

        LOG.debug(produtoDTO);

        return ResponseEntity.ok().body(produtoDTO);

    }

}