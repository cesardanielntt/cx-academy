package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModel;

public interface ClientePopulator {
    ClienteModel populateClienteModel(ClienteDTO source);

    ClienteDTO populateClienteDTO(ClienteModel cliente);
}
