package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.model.ClienteModel;

import java.util.Optional;

public interface ClienteFacade {
    ClienteDTO adicionar(ClienteDTO cliente);
    ClienteModel getClienteById(Integer id);
}
