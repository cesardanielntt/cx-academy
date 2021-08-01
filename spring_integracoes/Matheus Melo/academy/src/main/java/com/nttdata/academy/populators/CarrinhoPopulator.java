package com.nttdata.academy.populators;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.models.CarrinhoModels;

public interface CarrinhoPopulator {

    CarrinhoModels populateCarrinhoModels(CarrinhoDTO carrinhoDTO);

    CarrinhoDTO populateCarrinhoDTO(CarrinhoModels carrinho);
}
