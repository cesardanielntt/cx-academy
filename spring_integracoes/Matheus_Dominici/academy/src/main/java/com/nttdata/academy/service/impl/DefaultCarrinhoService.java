package com.nttdata.academy.service.impl;


import com.nttdata.academy.daos.CarrinhoRepository;

import com.nttdata.academy.models.CarrinhoModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("carrinhoService")
public class DefaultCarrinhoService {
    private static Logger LOG = LogManager.getLogger(DefaultCarrinhoService.class);

    private CarrinhoRepository carrinhoRepository;

    public DefaultCarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;
    }


    public CarrinhoModel adicionar(CarrinhoModel carrinho) {
        LOG.debug(carrinho);

        return carrinhoRepository.save(carrinho);
    }
}
