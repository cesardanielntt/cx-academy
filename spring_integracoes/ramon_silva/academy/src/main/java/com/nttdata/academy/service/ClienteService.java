package com.nttdata.academy.service;

import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.EnderecoModel;

import java.util.Optional;

public interface ClienteService {
    ClienteModel adicionar(ClienteModel cliente);

    Optional<ClienteModel> listar(Integer id);

    ClienteModel atualizar(ClienteModel cliente, Integer id);

}
