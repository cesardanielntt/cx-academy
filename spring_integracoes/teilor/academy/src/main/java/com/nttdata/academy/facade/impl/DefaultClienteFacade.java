package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.populator.ClientePopulator;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteFacade.class);

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientePopulator clientePopulator;

    @Override
    public void adicionar(ClienteDTO clienteDTO){

        LOG.debug(clienteDTO);

        ClienteModel cliente = clientePopulator.populateClienteModel(clienteDTO);

        cliente = clienteService.adicionar(cliente);

        clienteDTO = clientePopulator.populateClienteDTO(cliente);

    }

}
