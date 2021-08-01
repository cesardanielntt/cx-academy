package com.nttdata.academy.service.impl;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultPrecoService implements PrecoService {

    private static final Logger LOG = LogManager.getLogger(DefaultPrecoService.class);

    @Override
    public void adicionar(PrecoDTO preco) {
        LOG.debug(preco);
    }
}
