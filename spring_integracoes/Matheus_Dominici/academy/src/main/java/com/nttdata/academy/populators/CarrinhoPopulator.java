package com.nttdata.academy.populators;

import com.nttdata.academy.dto.CarrinhoDto;

import com.nttdata.academy.models.CarrinhoModel;


public interface CarrinhoPopulator {
    CarrinhoModel populateCarrinhoModel(CarrinhoDto carrinhoDto);

    CarrinhoDto populateCarrinhoDto(CarrinhoModel carrinho);
}
