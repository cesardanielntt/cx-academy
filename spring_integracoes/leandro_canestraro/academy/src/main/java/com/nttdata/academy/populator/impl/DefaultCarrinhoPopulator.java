package com.nttdata.academy.populator.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.model.CarrinhoModel;
import com.nttdata.academy.populator.CarrinhoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carrinhoPopulator")
public class DefaultCarrinhoPopulator implements CarrinhoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public CarrinhoModel populateCarrinhoModel(CarrinhoDTO source) {
        CarrinhoModel target =

        return null;
    }

    @Override
    public CarrinhoDTO populateCarrinhoDTO(CarrinhoModel source) {
        return null;
    }
}
