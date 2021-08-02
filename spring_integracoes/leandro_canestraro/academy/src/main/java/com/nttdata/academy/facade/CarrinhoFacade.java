package com.nttdata.academy.facade;

import com.nttdata.academy.dto.CarrinhoDTO;

import java.util.List;

public interface CarrinhoFacade {
    CarrinhoDTO adicionar(CarrinhoDTO source);

    List<CarrinhoDTO> getCarrinhoByCliente(Integer clienteId);

}
