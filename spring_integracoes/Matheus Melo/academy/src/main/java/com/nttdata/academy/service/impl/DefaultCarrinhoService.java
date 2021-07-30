package com.nttdata.academy.service.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.service.CarrinhoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultCarrinhoService implements CarrinhoService {

    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoService.class);

    @Override
    public void adicionar(CarrinhoDTO carrinho) {
        LOG.debug(carrinho);
    }
}
