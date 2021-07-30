package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.facade.ProdutoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("produtoFacade")
public class DefaultProdutoFacade implements ProdutoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultProdutoFacade.class);

    @Override
    public void adicionar(ProdutoDTO produtoDTO){

        LOG.debug(produtoDTO);

    }

}
