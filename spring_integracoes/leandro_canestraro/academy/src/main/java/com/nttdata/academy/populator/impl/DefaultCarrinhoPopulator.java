package com.nttdata.academy.populator.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.model.CarrinhoModel;
import com.nttdata.academy.model.ItemModel;
import com.nttdata.academy.populator.CarrinhoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("carrinhoPopulator")
public class DefaultCarrinhoPopulator implements CarrinhoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public CarrinhoModel populateCarrinhoModel(CarrinhoDTO source) {

        CarrinhoModel target = modelMapperService.modelMapper().map(source, CarrinhoModel.class);

        target.setItems(source.getItems().stream().map(item -> populateItemModel(item)).collect(Collectors.toList()));

        return target;
    }

    private ItemModel populateItemModel(ItemDTO source){

        ItemModel target = modelMapperService.modelMapper().map(source, ItemModel.class);

        target.getCliente().setId(source.getCliente().getId());
        target.getProduto().setId(source.getProduto().getId());
//        target.getPreco().setId(source.getPreco().getId());

        return target;
    }

    @Override
    public CarrinhoDTO populateCarrinhoDTO(CarrinhoModel source) {

        CarrinhoDTO target = modelMapperService.modelMapper().map(source, CarrinhoDTO.class);

        target.setItems(source.getItems().stream().map(item -> populateItemDTO(item)).collect(Collectors.toList()));

        return target;
    }

    private ItemDTO populateItemDTO(ItemModel source){

        ItemDTO target = modelMapperService.modelMapper().map(source, ItemDTO.class);

        target.getCliente().setId(source.getCliente().getId());
        target.getProduto().setId(source.getProduto().getId());
//        target.getPreco().setId(source.getPreco().getId());

        return target;
    }

}
