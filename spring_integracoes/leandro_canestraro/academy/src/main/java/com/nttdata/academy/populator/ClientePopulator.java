package com.nttdata.academy.populator;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.model.ClienteModel;

public interface ClientePopulator {
    ClienteModel populateClienteModel(ClienteDTO source);

    ClienteDTO populateClienteDTO(ClienteModel cliente);
}
