package com.nttdata.academy.service;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModel;

import java.util.Optional;

public interface ClienteService {
    ClienteModel adicionar(ClienteModel cliente);

    Optional<ClienteModel> listar(Integer id);

    ClienteModel atualizar(ClienteModel cliente, Integer id);

    ClienteModel deletar(Integer id);


}
