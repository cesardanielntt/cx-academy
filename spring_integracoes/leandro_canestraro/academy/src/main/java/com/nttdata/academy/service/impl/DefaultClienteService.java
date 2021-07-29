package com.nttdata.academy.service.impl;

import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultClienteService implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;


    @Override
    public void saveCliente(ClienteModel cliente) {
        if (cliente != null) {
            clienteDAO.save(cliente);
        }
    }
}
