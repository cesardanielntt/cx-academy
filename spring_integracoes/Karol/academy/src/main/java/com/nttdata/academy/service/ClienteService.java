package com.nttdata.academy.service;


import org.springframework.stereotype.Service;

@Service("clienteService")
public interface ClienteService{
    com.nttdata.academy.models.ClienteModel adicionar(com.nttdata.academy.models.ClienteModel cliente);
}
