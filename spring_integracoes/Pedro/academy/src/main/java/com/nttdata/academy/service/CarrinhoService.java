package com.nttdata.academy.service;

import com.nttdata.academy.models.CarrinhoModel;

import java.util.List;

public interface CarrinhoService {

    CarrinhoModel criar(CarrinhoModel carrinho);

    CarrinhoModel atualizar(CarrinhoModel carrinho, Integer id);

    public List<CarrinhoModel> consultar(Integer id);

    public List<CarrinhoModel> listar();

    public void deletar(Integer id);


}
