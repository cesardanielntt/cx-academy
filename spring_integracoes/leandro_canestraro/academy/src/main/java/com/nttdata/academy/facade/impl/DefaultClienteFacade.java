package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.dto.ClienteDataDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.populator.ClientePopulator;
import com.nttdata.academy.service.ClienteService;
import com.nttdata.academy.service.ModelMapperService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientePopulator clientePopulator;


    @Override
    public ClienteDataDTO adicionar(ClienteDataDTO source) {

//        ClienteModel target = new ClienteModel();
//        target.setName(source.getName());
//        target.setCpf(source.getCpf());
//        clienteService.saveCliente(target);

        ClienteModel cliente = clienteService.saveCliente(clientePopulator.populateClienteModel(source));

        source = clientePopulator.populateClienteDTO(cliente);

        return source;
    }
}
