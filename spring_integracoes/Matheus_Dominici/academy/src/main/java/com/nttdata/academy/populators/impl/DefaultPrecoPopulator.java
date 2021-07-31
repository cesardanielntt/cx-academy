package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.PrecoDto;
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
    public PrecoModel populatePrecoModel(PrecoDto precoDto) {
        return modelMapperService.modelMapper().map(precoDto, PrecoModel.class);
    }

    @Override
    public PrecoDto populatePrecoDto(PrecoModel preco) {
        return modelMapperService.modelMapper().map(preco, PrecoDto.class);
    }
}
