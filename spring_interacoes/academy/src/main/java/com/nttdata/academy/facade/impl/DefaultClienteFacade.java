package com.nttdata.academy.facade.impl;

import com.nttdata.academy.controller.ClienteController;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import org.springframework.stereotype.Service;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade{

    @Override
    public void adicionar(ClienteDTO cliente) {

    }
}
