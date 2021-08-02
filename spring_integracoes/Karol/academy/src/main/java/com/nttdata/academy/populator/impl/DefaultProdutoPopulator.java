package com.nttdata.academy.populator.impl;

import com.nttdata.academy.dto.ProdutoDTO;

import com.nttdata.academy.populator.ProdutoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("produtoPopulator")
public class DefaultProdutoPopulator implements ProdutoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public com.nttdata.academy.models.ProdutoModel populateProdutoModel(ProdutoDTO produtoDTO) {
        return modelMapperService.modelMapper().map(produtoDTO, com.nttdata.academy.models.ProdutoModel.class);
    }

    @Override
    public ProdutoDTO populateProdutoDto(com.nttdata.academy.models.ProdutoModel produto) {
        return modelMapperService.modelMapper().map(produto, ProdutoDTO.class);
    }
}
