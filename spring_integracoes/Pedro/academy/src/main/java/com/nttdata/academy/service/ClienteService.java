package com.nttdata.academy.service;

import com.nttdata.academy.models.ClienteModel;

import java.util.List;

public interface ClienteService {

    ClienteModel adicionar(ClienteModel cliente);

    void atualizar(ClienteModel cliente, String cpf);

    public List<ClienteModel> listar();

    public List<ClienteModel> consultarByCpf(String cpf);

    public void deletarByCpf(String cpf);

}
