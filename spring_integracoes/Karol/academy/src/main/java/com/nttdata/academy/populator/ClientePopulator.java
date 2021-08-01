package com.nttdata.academy.populator;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.model.ClienteModel;
import org.springframework.stereotype.Service;


public interface ClientePopulator  {
  ClienteModel populateClienteModel(ClienteDTO clienteDTO);

  ClienteDTO populateClienteDto(ClienteModel cliente);
}
