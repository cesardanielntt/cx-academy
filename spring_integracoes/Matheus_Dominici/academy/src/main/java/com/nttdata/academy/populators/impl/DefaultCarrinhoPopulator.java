package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.CarrinhoDto;
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
    public CarrinhoModel populateCarrinhoModel(CarrinhoDto carrinhoDto) {
        return modelMapperService.modelMapper().map(carrinhoDto, CarrinhoModel.class);
    }

    @Override
    public CarrinhoDto populateCarrinhoDto(CarrinhoModel carrinho) {
        return modelMapperService.modelMapper().map(carrinho, CarrinhoDto.class);
    }
}
