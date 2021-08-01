package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.CarrinhoRepository;
import com.nttdata.academy.models.*;
import com.nttdata.academy.service.CarrinhoService;
import com.nttdata.academy.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("carrinhoService")
public class DefaultCarrinhoService implements CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    public DefaultCarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }

    @Override
    public Optional<CarrinhoModel> listar(Integer id) {
        return carrinhoRepository.findById(id);
    }

    @Override
    public CarrinhoModel adicionar(CarrinhoModel carrinho) {

        for (ItemModel item : carrinho.getItems()) {
            carrinho.setTotal(item.getTotal());
        }

        return carrinhoRepository.save(carrinho);
    }


    @Override
    public CarrinhoModel atualizar(CarrinhoModel carrinho, Integer id) {

        for (ItemModel item : carrinho.getItems()) {
            carrinho.setTotal(item.getTotal());
        }

        carrinho.setId(id);

        return carrinhoRepository.save(carrinho);
    }

    @Override
    public CarrinhoModel deletar(Integer id) {

        carrinhoRepository.deleteById(id);

        return null;
    }
}
