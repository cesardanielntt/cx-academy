package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void adicionar(ProdutoDTO source) {
        ProdutoModel target = new ProdutoModel();
        target.setSku(source.getSku());
        target.setName(source.getName());
        target.setBrand(source.getBrand());

        produtoService.saveProduto(target);
    }
}
