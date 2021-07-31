package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.EnderecoModel;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClienteFacade {

    ResponseEntity adicionar(ClienteDTO cliente);

    ResponseEntity<Optional<ClienteModel>> listar(Integer id);

    ResponseEntity<ClienteDTO> atualizar(ClienteDTO clienteDTO, Integer id);

    ResponseEntity deletar(Integer id);

}
