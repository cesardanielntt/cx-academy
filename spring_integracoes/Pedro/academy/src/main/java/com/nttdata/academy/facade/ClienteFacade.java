package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteFacade {

    ResponseEntity adicionar(ClienteDTO cliente);

    void atualizar(ClienteDTO cliente, String cpf);

    public List<ClienteDTO> listar();

    public List<ClienteDTO> consultarByCpf(String cpf);

    public void deletarByCpf(String cpf);

}
