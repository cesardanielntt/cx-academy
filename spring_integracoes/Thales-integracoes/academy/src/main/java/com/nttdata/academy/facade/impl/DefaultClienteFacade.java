package com.nttdata.academy.facade.impl;

import com.nttdata.academy.controller.ClienteController;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {





    @Override
    public void adicionar(ClienteDTO cliente) {

    }
}
