package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModels;
import com.nttdata.academy.populators.ClientePopulator;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteFacade.class);

    @Autowired
    private ClientePopulator clientePopulator;

    @Autowired
    private ClienteService clienteService;

    @Override
    public ClienteDTO adicionar(ClienteDTO clienteDTO) {

        LOG.debug(clienteDTO);

        ClienteModels cliente = clientePopulator.populateClienteModel(clienteDTO);

        cliente = clienteService.adicionar(cliente);

        clienteDTO = clientePopulator.populateCriateDTO(cliente);

        return clienteDTO;
    }
}
