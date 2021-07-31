package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultClienteService implements ClienteService {


    private ClienteDAO clienteDAO;

    @Autowired
    public DefaultClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    private static final Logger LOG = LogManager.getLogger(DefaultClienteService.class);

    @Override
    public ClienteModel saveCliente(ClienteModel cliente) {

        LOG.debug(cliente);

        if (cliente != null) {
            return clienteDAO.save(cliente);
        }
        return null;
    }

    @Override
    public ClienteModel getClienteById(Integer id) {
        return clienteDAO.getById(id);
    }

    @Override
    public List<ClienteModel> getClientes() {
        return clienteDAO.findAll();
    }


}
