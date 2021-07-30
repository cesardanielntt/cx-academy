package com.nttdata.academy.populator;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModel;

public interface ClientePopulator{

    ClienteModel populateClienteModel(ClienteDTO clienteDTO);

    ClienteDTO populateClienteDTO(ClienteModel cliente);
}
