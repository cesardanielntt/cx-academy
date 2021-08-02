package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.PrecoDTO;
import com.nttdata.academy.models.PrecoModel;
import com.nttdata.academy.populators.PrecoPopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("precoPopulator")
public class DefaultPrecoPopulator implements PrecoPopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public PrecoModel populatePrecoModel(PrecoDTO precoDTO) {
        PrecoModel preco = modelMapperService.modelMapper().map(precoDTO, PrecoModel.class);
        return preco;
    }

    @Override
    public PrecoDTO populatePrecoDto(PrecoModel preco) {
        PrecoDTO precoDTO = modelMapperService.modelMapper().map(preco, PrecoDTO.class);
        return precoDTO;
    }
}
