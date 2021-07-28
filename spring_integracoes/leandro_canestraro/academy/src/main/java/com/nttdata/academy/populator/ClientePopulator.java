package com.nttdata.academy.populator;

import com.nttdata.academy.dto.ClienteDataDTO;
import com.nttdata.academy.model.ClienteModel;

public interface ClientePopulator {
    ClienteModel populateClienteModel(ClienteDataDTO source);

    ClienteDataDTO populateClienteDTO(ClienteModel cliente);
}
