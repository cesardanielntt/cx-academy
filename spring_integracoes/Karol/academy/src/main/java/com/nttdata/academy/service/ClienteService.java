package com.nttdata.academy.service;

import com.nttdata.academy.model.ClienteModel;
import org.springframework.stereotype.Service;

@Service("clienteService")
public interface ClienteService{
    ClienteModel adicionar(ClienteModel cliente);
}
