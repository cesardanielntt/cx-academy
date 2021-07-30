package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.populator.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.LogManager;

@Service("clienteFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoFacade.class);

    @Autowired
    private ProdutoPopulator produtoPopulator;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public ProdutoDTO adicionar(ProdutoDTO produtoDTO){

        LOG.debug(produtoDTO);

        ProdutoModel produto = produtoPopulator.populateProdutoModel(produtoDTO);

        cliente = clienteService.adicionar(cliente);

        ClienteDTO = clientePopulator.populateProdutoDto(produto);

        return produtoDTO;
    }
}
