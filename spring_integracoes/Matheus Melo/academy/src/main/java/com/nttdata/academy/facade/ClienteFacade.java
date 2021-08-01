package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.models.ClienteModels;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClienteFacade {

    ResponseEntity adicionar(ClienteDTO cliente);

    ResponseEntity<ClienteDTO> atualizar(ClienteDTO clienteDTO, Integer id);

    ResponseEntity deletar(Integer id);

    ResponseEntity<Optional<ClienteModels>> listar(Integer id);

}
