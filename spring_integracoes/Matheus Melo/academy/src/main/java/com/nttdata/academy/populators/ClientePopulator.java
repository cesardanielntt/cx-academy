package com.nttdata.academy.populators;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModels;

public interface ClientePopulator {

    ClienteModels populateClienteModel(ClienteDTO clienteDTO);


    ClienteDTO populateCriateDTO(ClienteModels cliente);
}
