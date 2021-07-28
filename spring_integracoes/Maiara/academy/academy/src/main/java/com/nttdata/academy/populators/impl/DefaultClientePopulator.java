package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.populators.ClientePopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("clientePopulator")
public class DefaultClientePopulator  implements ClientePopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ClienteModel populateClienteModel (ClienteDTO clienteDTO) {
        return modelMapperService.modelMapper().map(clienteDTO, ClienteModel.class);
    }

    @Override
    public ClienteDTO populateClienteDTO(ClienteModel cliente) {
        return modelMapperService.modelMapper().map(cliente, ClienteDTO.class);


    }
}
