package com.nttdata.academy.facade.impl;



import com.nttdata.academy.populators.PrecoPopulator;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("precoFacade")
public class DefaultPrecoFacade {

    private static Logger LOG = LogManager.getLogger(DefaultPrecoFacade.class);

    @Autowired
    private PrecoPopulator precoPopulator;

    @Autowired
    private PrecoService precoService;

}

