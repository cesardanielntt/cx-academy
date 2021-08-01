package com.nttdata.academy.service;

import com.nttdata.academy.models.CarrinhoModels;

import java.util.Optional;

public interface CarrinhoService {

    CarrinhoModels adicionar(CarrinhoModels carrinho);

    Optional<CarrinhoModels> listar(Integer id);

    CarrinhoModels atualizar(CarrinhoModels carrinho, Integer id);

    CarrinhoModels deletar(Integer id);
}
