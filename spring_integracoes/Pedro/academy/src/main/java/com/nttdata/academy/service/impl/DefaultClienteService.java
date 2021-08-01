package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ClienteRepository;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.lang.Integer;

@Service("clienteService")
@Transactional
public class DefaultClienteService implements ClienteService {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteService.class);

    private ClienteRepository clienteRepository;

    @Autowired
    public DefaultClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;

    }

    @Override
    public ClienteModel adicionar(ClienteModel cliente) {

        LOG.debug(cliente);
        System.out.println("Cliente adicionado ao banco!");

        return clienteRepository.save(cliente);

    }

    @Override
    public void atualizar(ClienteModel cliente, Integer id){

        cliente.setId(id);

        LOG.debug(cliente);

        clienteRepository.save(cliente);

    }

    @Override
    public List<ClienteModel> listar() {

        System.out.println("Pegando os clientes do banco...");

        return clienteRepository.findAll();

    }

    @Override
    public List<ClienteModel> consultar(Integer id) {

        System.out.println("Pegando os clientes do banco...");

        return clienteRepository.findAllById(Collections.singleton(id));

    }

    @Override
    public void deletar(Integer id){

        clienteRepository.removeClienteModelById(id);
    }

}
