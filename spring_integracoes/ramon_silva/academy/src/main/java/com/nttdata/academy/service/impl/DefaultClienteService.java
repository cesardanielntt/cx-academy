package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ClienteRepository;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("clienteService")
public class DefaultClienteService implements ClienteService {

    private static final Logger LOG = LogManager.getLogger(ClienteService.class);

    private ClienteRepository clienteRepository;

    @Autowired
    public DefaultClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteModel adicionar(ClienteModel cliente) {

        LOG.debug(cliente);

        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<ClienteModel> listar(Integer id) {
        return clienteRepository.findById(id);
    }

    @Override
    public ClienteModel atualizar(ClienteModel cliente, Integer id) {

        cliente.setId(id);

        return clienteRepository.save(cliente);
    }


}
