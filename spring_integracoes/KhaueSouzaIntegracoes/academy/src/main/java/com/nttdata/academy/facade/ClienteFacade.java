package com.nttdata.academy.facade;

import com.nttdata.academy.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;

public interface ClienteFacade {

    ResponseEntity adicionar(ClienteDTO cliente);

}