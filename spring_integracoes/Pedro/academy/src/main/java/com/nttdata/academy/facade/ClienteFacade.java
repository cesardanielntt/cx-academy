package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteFacade {

    ResponseEntity adicionar(ClienteDTO cliente);

    void atualizar(ClienteDTO cliente, Integer id);

    public List<ClienteDTO> listar();

    public ClienteDTO consultar(Integer id);

    public void deletar(Integer id);

}
