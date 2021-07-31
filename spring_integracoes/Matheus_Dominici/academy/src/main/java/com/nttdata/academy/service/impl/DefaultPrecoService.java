package com.nttdata.academy.service.impl;


import com.nttdata.academy.daos.PrecoRepository;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.service.PrecoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("precoService")
public class DefaultPrecoService implements PrecoService {
    private static Logger LOG = LogManager.getLogger(DefaultPrecoService.class);


    private PrecoRepository precoRepository;

    public DefaultPrecoService(PrecoRepository precoRepository) {
        this.precoRepository = precoRepository;
    }

    @Override
    public PrecoModel adicionar(PrecoModel preco) {
        LOG.debug(preco);

        return precoRepository.save(preco);
    }
}
