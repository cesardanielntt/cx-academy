package com.nttdata.academy.populator.impl;

import com.nttdata.academy.dto.ClienteDataDTO;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.populator.ClientePopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientePopulator")
public class DefaultClientPopulator implements ClientePopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ClienteModel populateClienteModel(ClienteDataDTO source) {
        return modelMapperService.modelMapper().map(source, ClienteModel.class);
    }

    @Override
    public ClienteDataDTO populateClienteDTO(ClienteModel source) {
        return modelMapperService.modelMapper().map(source, ClienteDataDTO.class);
    }
}
