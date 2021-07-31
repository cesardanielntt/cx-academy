package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.CarrinhoRepository;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("carrinhoService")
public class DefaultCarrinhoService implements CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    @Autowired
    public DefaultCarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public CarrinhoModel adicionar(CarrinhoModel carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    @Override
    public Optional<CarrinhoModel> listar(Integer id) {
        return carrinhoRepository.findById(id);
    }

    @Override
    public CarrinhoModel atualizar(CarrinhoModel carrinho, Integer id) {

        carrinho.setId(id);

        return carrinhoRepository.save(carrinho);
    }
}
