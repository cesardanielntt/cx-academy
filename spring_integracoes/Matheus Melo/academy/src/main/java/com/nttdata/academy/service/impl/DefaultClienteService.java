package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ClienteRepositoryDao;
import com.nttdata.academy.models.ClienteModels;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clienteService")
public class DefaultClienteService implements ClienteService {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteService.class);

    private ClienteRepositoryDao clienteRepositoryDao;

    @Autowired
    public DefaultClienteService(ClienteRepositoryDao clienteRepositoryDao) {
        this.clienteRepositoryDao = clienteRepositoryDao;
    }

    @Override
    public ClienteModels adicionar(ClienteModels cliente) {

        LOG.debug(cliente);

        return clienteRepositoryDao.save(cliente);
    }
}
