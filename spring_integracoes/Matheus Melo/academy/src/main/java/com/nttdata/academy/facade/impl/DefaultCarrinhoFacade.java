package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.CarrinhoDTO;
import com.nttdata.academy.facade.CarrinhoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("carrinhoFacade")
public class DefaultCarrinhoFacade implements CarrinhoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultCarrinhoFacade.class);

    @Override
    public void adicionar(CarrinhoDTO carrinho) {
        LOG.debug(carrinho);
    }
}
