package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.PrecoFacade;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.populators.PrecoPopulator;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("precoFacade")
public class DefaultPrecoFacade implements PrecoFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultPrecoFacade.class);

    @Autowired
    private PrecoPopulator precoPopulator;

    @Autowired
    private PrecoService precoService;

    @Override
    public PrecoDTO adicionar(PrecoDTO precoDTO) {

        LOG.debug(precoDTO);

        PrecoModel preco = precoPopulator.populatePrecoModel(precoDTO);

        preco = precoService.adicionar(preco);

        precoDTO = precoPopulator.populatePrecoDTO(preco);

        return precoDTO;

    }

}
