package com.nttdata.academy.service;

import com.nttdata.academy.model.ClienteModel;

import java.util.Optional;

public interface ClienteService {

    ClienteModel saveCliente(ClienteModel cliente);

    ClienteModel getClienteById(Integer id);
}
