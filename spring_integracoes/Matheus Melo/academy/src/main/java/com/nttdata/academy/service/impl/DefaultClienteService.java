package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ClienteRepositoryDao;
import com.nttdata.academy.models.ClienteModels;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("clienteService")
public class DefaultClienteService implements ClienteService {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteService.class);

    private ClienteRepositoryDao clienteRepository;

    @Autowired
    public DefaultClienteService(ClienteRepositoryDao clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteModels adicionar(ClienteModels cliente) {

        LOG.debug(cliente);

        return clienteRepository.save(cliente);

    }

    @Override
    public Optional<ClienteModels> listar(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteModels atualizar(ClienteModels cliente, Integer id) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    @Override
    public ClienteModels deletar(Integer id) {
        clienteRepository.deleteById(id);
        return null;
    }

}