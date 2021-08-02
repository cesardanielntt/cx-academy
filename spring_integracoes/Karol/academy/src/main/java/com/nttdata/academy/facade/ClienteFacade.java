package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClienteFacade {

    ResponseEntity adicionar(ClienteDTO cliente);

    ResponseEntity<ClienteDTO> update(ClienteDTO clienteDTO, Integer id);

    ResponseEntity delete(Integer id);

    ResponseEntity<Optional<com.nttdata.academy.models.ClienteModel>> listar(Integer id);

}