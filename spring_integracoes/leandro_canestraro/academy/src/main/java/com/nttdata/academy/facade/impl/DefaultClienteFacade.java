package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.populator.ClientePopulator;
import com.nttdata.academy.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientePopulator clientePopulator;


    @Override
    public ClienteDTO adicionar(ClienteDTO source) {

        ClienteModel cliente = clienteService
                .saveCliente(clientePopulator
                        .populateClienteModel(source));

        source = clientePopulator.populateClienteDTO(cliente);

        return source;
    }
}
