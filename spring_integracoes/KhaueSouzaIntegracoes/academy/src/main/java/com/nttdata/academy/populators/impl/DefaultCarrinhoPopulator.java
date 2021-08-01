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
        return modelMapperService.modelMapper().map(carrinhoDTO, CarrinhoModel.class);
    }
    @Override
    public CarrinhoDTO populateCarrinhoDTO(CarrinhoModel carrinho) {
        return modelMapperService.modelMapper().map(carrinho, CarrinhoDTO.class);
    }
}
