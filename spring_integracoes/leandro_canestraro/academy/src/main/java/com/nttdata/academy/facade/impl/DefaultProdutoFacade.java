package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.populator.ProdutoPopulator;
import com.nttdata.academy.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Communication between Controller and Service layers
@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoPopulator produtoPopulator;

    //Call service to insert on db
    @Override
    public ProdutoDTO adicionar(ProdutoDTO source) {

        ProdutoModel produto = produtoService.saveProduto(produtoPopulator.populateProdutoModel(source));

        source = produtoPopulator.populateProdutoDTO(produto);

        return source;
    }
}