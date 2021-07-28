package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteFacade.class);


    @Override
    public void adicionar(ClienteDTO cliente) {

        LOG.debug(cliente);
    }
}
