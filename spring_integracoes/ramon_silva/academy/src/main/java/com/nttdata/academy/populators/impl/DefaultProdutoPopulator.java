package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.models.ProdutoModel;
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
    public ProdutoModel populateProdutoModel(ProdutoDTO produtoDTO) {
        ProdutoModel produto = modelMapperService.modelMapper().map(produtoDTO, ProdutoModel.class);

        produto.setPrecos(produtoDTO.getPrecos()
        .stream()
        .map(e -> populatePrecoModel(e)).collect(Collectors.toList()));

        produto.setItems(produtoDTO.getItems()
                .stream()
                .map(e -> populateItemModel(e)).collect(Collectors.toList()));

        return produto;
    }

    private PrecoModel populatePrecoModel(PrecoDTO preco) {
        return modelMapperService.modelMapper().map(preco, PrecoModel.class);
    }

    private ItemModel populateItemModel(ItemDTO item) {
        return modelMapperService.modelMapper().map(item, ItemModel.class);
    }

    @Override
    public ProdutoDTO populateProdutoDTO(ProdutoModel produto) {
        ProdutoDTO produtoDTO = modelMapperService.modelMapper().map(produto, ProdutoDTO.class);

        produtoDTO.setPrecos(produto.getPrecos()
                .stream()
                .map(e -> populatePrecoDTO(e)).collect(Collectors.toList()));

        produtoDTO.setItems(produto.getItems()
                .stream()
                .map(e -> populateItemDTO(e)).collect(Collectors.toList()));

        return produtoDTO;
    }

    private PrecoDTO populatePrecoDTO(PrecoModel preco) {
        return modelMapperService.modelMapper().map(preco, PrecoDTO.class);
    }

    private ItemDTO populateItemDTO(ItemModel item) {
        return modelMapperService.modelMapper().map(item, ItemDTO.class);
    }

}
