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
        return modelMapperService.modelMapper().map(precoDTO, PrecoModel.class);
    }

    @Override
    public PrecoDTO populatePrecoDTO(PrecoModel preco) {
        return modelMapperService.modelMapper().map(preco, PrecoDTO.class);

    }

}
