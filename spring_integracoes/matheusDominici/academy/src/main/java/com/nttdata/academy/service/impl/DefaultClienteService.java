package com.nttdata.academy.service.impl;


import com.nttdata.academy.facade.impl.DefaultClienteFacade;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("clienteService")
public class DefaultClienteService implements ClienteService {

    private static Logger LOG = LogManager.getLogger(DefaultClienteService.class);



}
