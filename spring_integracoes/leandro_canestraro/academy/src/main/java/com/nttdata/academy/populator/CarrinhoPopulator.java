package com.nttdata.academy.populator;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.model.CarrinhoModel;

public interface CarrinhoPopulator {

    CarrinhoModel populateCarrinhoModel(CarrinhoDTO source);

    CarrinhoDTO populateCarrinhoDTO(CarrinhoModel source);
}
