package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ProdutoModel;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("produtoPopulator")
public class DefaultProdutoPopulator implements ProdutoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ProdutoModel populateProdutoModel(ProdutoDTO produtoDTO) {
        return modelMapperService.modelMapper().map(produtoDTO, ProdutoModel.class);
    }

    @Override
    public ProdutoDTO populateProdutoDTO(ProdutoModel produto) {
        return modelMapperService.modelMapper().map(produto, ProdutoDTO.class);
    }
}
