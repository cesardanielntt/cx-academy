package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ItemModels;
import com.nttdata.academy.models.PrecoModels;
import com.nttdata.academy.models.ProdutoModels;
import com.nttdata.academy.populators.ProdutoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("produtoPopulator")
public class DefaultProdutoPopulator implements ProdutoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ProdutoModels populateProdutoModels(ProdutoDTO produtoDTO) {
        ProdutoModels produto = modelMapperService.modelMapper().map(produtoDTO, ProdutoModels.class);
        produto.setPrecos(produtoDTO.getPrecos().stream().map(e -> populatePrecoModels(e)).collect(Collectors.toList()));
        produto.setItems(produtoDTO.getItems().stream().map(e -> populateItemModels(e)).collect(Collectors.toList()));

        return produto;
    }

    private PrecoModels populatePrecoModels(PrecoDTO preco){
        return modelMapperService.modelMapper().map(preco, PrecoModels.class);
    }

    private ItemModels populateItemModels(ItemDTO item){
        return modelMapperService.modelMapper().map(item, ItemModels.class);
    }

    @Override
    public ProdutoDTO populateProdutoDTO(ProdutoModels produto) {
        ProdutoDTO produtoDTO = modelMapperService.modelMapper().map(produto, ProdutoDTO.class);
        produtoDTO.setPrecos(produto.getPrecos().stream().map(e -> populatePrecoDTO(e)).collect(Collectors.toList()));
        produtoDTO.setItems(produto.getItems().stream().map(e -> populateItemDTO(e)).collect(Collectors.toList()));

        return  produtoDTO;
    }

    private PrecoDTO populatePrecoDTO(PrecoModels preco){
        return modelMapperService.modelMapper().map(preco, PrecoDTO.class);
    }

    private ItemDTO populateItemDTO(ItemModels item) {
        return modelMapperService.modelMapper().map(item, ItemDTO.class);
    }
}
