package com.nttdata.academy.populators;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.models.CarrinhoModel;

public interface CarrinhoPopulator {

    CarrinhoModel populateCarrinhoModel(CarrinhoDTO carrinhoDTO);

    CarrinhoDTO populateCarrinhoDTO(CarrinhoModel carrinho);

}
