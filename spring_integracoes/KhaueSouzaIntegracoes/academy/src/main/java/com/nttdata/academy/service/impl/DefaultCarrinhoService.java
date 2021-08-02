package com.nttdata.academy.service.impl;


import com.nttdata.academy.daos.CarrinhoRepository;
import com.nttdata.academy.models.CarrinhoModel;
import com.nttdata.academy.service.CarrinhoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carrinhoService")
public class DefaultCarrinhoService implements CarrinhoService {

    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoService.class);

    private CarrinhoRepository carrinhoRepository;

    @Autowired
    public DefaultCarrinhoService(CarrinhoRepository carrinhoRepository) {
        this.carrinhoRepository = carrinhoRepository;

    }


    @Override
    public CarrinhoModel adicionar(CarrinhoModel carrinho) {

        LOG.debug(carrinho);

        return carrinhoRepository.save(carrinho);
    }
}
