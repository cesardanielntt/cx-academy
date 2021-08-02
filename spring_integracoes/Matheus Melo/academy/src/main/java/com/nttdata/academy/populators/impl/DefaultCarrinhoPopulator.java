package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.models.CarrinhoModels;
import com.nttdata.academy.models.ItemModels;
import com.nttdata.academy.populators.CarrinhoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("carrinhoPopulator")
public class DefaultCarrinhoPopulator implements CarrinhoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;


    @Override
    public CarrinhoModels populateCarrinhoModels(CarrinhoDTO carrinhoDTO) {
        CarrinhoModels carrinho = modelMapperService.modelMapper().map(carrinhoDTO, CarrinhoModels.class);

        carrinho.setItems(carrinhoDTO.getItems().stream().map(e -> populateItemModels(e)).collect(Collectors.toList()));

        return carrinho;
    }

    private ItemModels populateItemModels(ItemDTO item) {
        return modelMapperService.modelMapper().map(item, ItemModels.class);
    }

    @Override
    public CarrinhoDTO populateCarrinhoDTO(CarrinhoModels carrinho) {
        CarrinhoDTO carrinhoDTO = modelMapperService.modelMapper().map(carrinho, CarrinhoDTO.class);
        carrinhoDTO.setItems(carrinho.getItems().stream().map(e -> populateItemDTO(e)).collect(Collectors.toList()));

        return carrinhoDTO;
    }

    private ItemDTO populateItemDTO(ItemModels item){
        return modelMapperService.modelMapper().map(item, ItemDTO.class);
    }
}
