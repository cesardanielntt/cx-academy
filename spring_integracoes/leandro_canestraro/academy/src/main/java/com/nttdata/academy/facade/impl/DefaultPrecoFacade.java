package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.facade.PrecoFacade;
import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.populator.PrecoPopulator;
import com.nttdata.academy.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service ("precoFacade")
public class DefaultPrecoFacade implements PrecoFacade {

    @Autowired
    private PrecoService precoService;
    @Autowired
    private PrecoPopulator precoPopulator;

    @Override
    public PrecoDTO adicionar(PrecoDTO source) {

        PrecoModel preco = precoService
                .savePreco(precoPopulator
                        .populatePrecoModel(source));

        System.out.println(preco);

        source = precoPopulator.populatePrecoDTO(preco);

        return source;
    }

    @Override
    public List<PrecoDTO> getPrecoByCliente(Integer clienteId) {

        List<PrecoDTO> target = new ArrayList<>();
        List<PrecoModel> precos = precoService.getPrecoByCliente(clienteId);

        for(PrecoModel preco : precos) {
            target.add(precoPopulator.populatePrecoDTO(preco));
        }

        return target;
    }
}
