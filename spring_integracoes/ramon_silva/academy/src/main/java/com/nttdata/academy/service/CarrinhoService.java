package com.nttdata.academy.service;

import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.ClienteModel;

import java.util.Optional;

public interface CarrinhoService {
    CarrinhoModel adicionar(CarrinhoModel carrinho);

    Optional<CarrinhoModel> listar(Integer id);

    CarrinhoModel atualizar(CarrinhoModel carrinho, Integer id);
}
