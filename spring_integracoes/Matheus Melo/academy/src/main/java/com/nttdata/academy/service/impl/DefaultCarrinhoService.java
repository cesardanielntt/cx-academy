package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.CarrinhoRepositoryDao;
import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.models.CarrinhoModels;
import com.nttdata.academy.service.CarrinhoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("carrinhoService")
public class DefaultCarrinhoService implements CarrinhoService {

    private CarrinhoRepositoryDao carrinhoRepositoryDao;

    @Autowired
    public DefaultCarrinhoService(CarrinhoRepositoryDao carrinhoRepositoryDao){
        this.carrinhoRepositoryDao = carrinhoRepositoryDao;
    }

    @Override
    public CarrinhoModels adicionar(CarrinhoModels carrinho) {
        return carrinhoRepositoryDao.save(carrinho);
    }

    @Override
    public Optional<CarrinhoModels> listar(Integer id) {
        return carrinhoRepositoryDao.findById(id);
    }

    @Override
    public CarrinhoModels atualizar(CarrinhoModels carrinho, Integer id) {
        carrinho.setId(id);
        return carrinhoRepositoryDao.save(carrinho);
    }

    @Override
    public CarrinhoModels deletar(Integer id) {
        carrinhoRepositoryDao.deleteById(id);
        return null;
    }
}
