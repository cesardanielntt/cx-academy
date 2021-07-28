package com.nttdata.academy.facade.impl;

import com.nttdata.academy.controller.ClienteController;
import com.nttdata.academy.controller.ProdutoController;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    @Autowired
    public ProdutoPopulator produtoPopulator;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public  ProdutoDTO adicionar(ProdutoDTO produtoDTO) {

        ProdutoModel produto = produtoPopulator.populateProdutoModel(produtoDTO);

        produto = produtoService.adicionar(produto);

        produtoDTO = produtoPopulator.populateProdutoDTO(produto);

        return produtoDTO;

    }

}
