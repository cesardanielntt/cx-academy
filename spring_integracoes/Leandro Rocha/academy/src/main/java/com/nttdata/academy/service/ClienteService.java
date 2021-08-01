package com.nttdata.academy.service;

import com.nttdata.academy.models.ClienteModel;

public interface ClienteService {
    default ClienteModel adicionar(ClienteModel cliente) {
        return null;
    }

    ClienteModel saveCliente(ClienteModel cliente);
}
