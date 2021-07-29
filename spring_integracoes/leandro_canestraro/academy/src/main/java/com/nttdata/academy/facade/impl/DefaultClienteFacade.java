package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.dto.ClienteDataDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public void adicionar(ClienteDataDTO source) {
        ClienteModel target = new ClienteModel();
        target.setName(source.getName());
        target.setCpf(source.getCpf());
        clienteDAO.save(target);
    }
}
