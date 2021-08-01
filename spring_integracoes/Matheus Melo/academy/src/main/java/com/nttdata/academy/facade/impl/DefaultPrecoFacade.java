package com.nttdata.academy.facade.impl;


import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.PrecoFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("precoFacade")
public class DefaultPrecoFacade implements PrecoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultPrecoFacade.class);

    @Override
    public void adicionar(PrecoDTO preco) {
        LOG.debug(preco);
    }
}