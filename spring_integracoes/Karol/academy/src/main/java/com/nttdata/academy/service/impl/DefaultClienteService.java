package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.ClienteRepository;

import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("clienteService")
public class DefaultClienteService implements ClienteService {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteService.class);

    private ClienteRepository clienteRepository;

    @Autowired
    public DefaultClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public com.nttdata.academy.models.ClienteModel adicionar(com.nttdata.academy.models.ClienteModel cliente) {

        LOG.debug(cliente);

        cliente.getId();

        cliente = clienteRepository.save(cliente);

        cliente.getId();

        return clienteRepository.save(cliente);
    }

}
