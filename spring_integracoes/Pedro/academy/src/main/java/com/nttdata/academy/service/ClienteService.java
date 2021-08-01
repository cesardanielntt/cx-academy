package com.nttdata.academy.service;

import com.nttdata.academy.models.ClienteModel;

import java.util.List;

public interface ClienteService {

    ClienteModel adicionar(ClienteModel cliente);

    void atualizar(ClienteModel cliente, Integer id);

    public List<ClienteModel> listar();

    public List<ClienteModel> consultar(Integer id);

    public void deletar(Integer id);

}
