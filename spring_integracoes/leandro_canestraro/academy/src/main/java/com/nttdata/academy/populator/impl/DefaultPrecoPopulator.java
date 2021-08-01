package com.nttdata.academy.populator.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.dto.ProdutoDTO;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.model.ProdutoModel;
import com.nttdata.academy.populator.PrecoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("precoPopulator")
public class DefaultPrecoPopulator implements PrecoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public PrecoModel populatePrecoModel(PrecoDTO source) {
        PrecoModel target = modelMapperService.modelMapper().map(source, PrecoModel.class);
        target.getCliente().setId(source.getCliente().getId());
        target.getProduto().setId(source.getProduto().getId());
        return target;
    }

    @Override
    public PrecoDTO populatePrecoDTO(PrecoModel source) {
        PrecoDTO target = modelMapperService.modelMapper().map(source, PrecoDTO.class);
        target.getCliente().setId(source.getCliente().getId());
        target.getProduto().setId(source.getProduto().getId());
        return target;
    }
}