package com.nttdata.academy.service;

import com.nttdata.academy.models.ClienteModels;

import java.util.Optional;

public interface ClienteService {

    ClienteModels adicionar(ClienteModels cliente);

    Optional<ClienteModels> listar(Integer id);

    ClienteModels atualizar(ClienteModels cliente, Integer id);

    ClienteModels deletar(Integer id);
}