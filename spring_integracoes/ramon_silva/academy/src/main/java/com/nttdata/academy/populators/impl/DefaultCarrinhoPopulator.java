package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.ItemDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.ItemModel;
import com.nttdata.academy.models.ProdutoModel;
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
    public CarrinhoModel populateCarrinhoModel(CarrinhoDTO carrinhoDTO) {
        CarrinhoModel carrinho = modelMapperService.modelMapper().map(carrinhoDTO, CarrinhoModel.class);

        carrinho.setItems(carrinhoDTO.getItems()
        .stream()
        .map(e -> populateItemModel(e)).collect(Collectors.toList()));

        return carrinho;
    }

    private ItemModel populateItemModel(ItemDTO item) {
        return modelMapperService.modelMapper().map(item, ItemModel.class);
    }

    @Override
    public CarrinhoDTO populateCarrinhoDTO(CarrinhoModel carrinho) {
        CarrinhoDTO carrinhoDTO = modelMapperService.modelMapper().map(carrinho, CarrinhoDTO.class);

        carrinhoDTO.setItems(carrinho.getItems()
                .stream()
                .map(e -> populateItemDTO(e)).collect(Collectors.toList()));

        return carrinhoDTO;
    }

    private ItemDTO populateItemDTO(ItemModel item) {
        return modelMapperService.modelMapper().map(item, ItemDTO.class);
    }
}
