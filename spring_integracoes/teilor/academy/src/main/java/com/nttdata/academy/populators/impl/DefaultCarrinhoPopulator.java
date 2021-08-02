package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.populators.CarrinhoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carrinhoPopulator")
public class DefaultCarrinhoPopulator implements CarrinhoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public CarrinhoModel populateCarrinhoModel(CarrinhoDTO carrinhoDTO) {
        CarrinhoModel carrinho = modelMapperService.modelMapper().map(carrinhoDTO, CarrinhoModel.class);
        return carrinho;
    }

    @Override
    public CarrinhoDTO populateCarrinhoDto(CarrinhoModel carrinho) {
        CarrinhoDTO carrinhoDTO = modelMapperService.modelMapper().map(carrinho, CarrinhoDTO.class);
        return carrinhoDTO;
    }
}
