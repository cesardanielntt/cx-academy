package com.nttdata.academy.service;

import com.nttdata.academy.model.CarrinhoModel;

import java.util.List;

public interface CarrinhoService {

    CarrinhoModel saveToCart(CarrinhoModel source);

    List<CarrinhoModel> getCarrinhoByCliente(Integer clienteId);

}
