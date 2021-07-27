package com.nttdata.academy.facade.impl;



import com.nttdata.academy.dto.ClienteDto;
import com.nttdata.academy.facade.ClienteFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    private static Logger LOG = LogManager.getLogger(DefaultClienteFacade.class);

    @Override
    public void adicionar(ClienteDto cliente) {
        LOG.debug(cliente);
    }
}
