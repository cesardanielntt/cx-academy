package com.nttdata.academy.service.impl;

import com.nttdata.academy.daos.ClienteRepository;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.EnderecoModel;
import com.nttdata.academy.service.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("clienteService")
@Transactional
public class DefaultClienteService implements ClienteService {

    private static final Logger LOG = LogManager.getLogger(DefaultClienteService.class);

    private ClienteRepository clienteRepository;

    @Autowired
    public DefaultClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteModel adicionar(ClienteModel cliente) {

        LOG.debug(cliente);
        System.out.println("Cliente adicionado ao banco!");
        return clienteRepository.save(cliente);

    }

    @Override
    public void atualizar(ClienteModel cliente, String cpf) {

        LOG.debug(cliente);
        System.out.println("Cliente atualizado!");

        String newNome="";
        String newCpf="";

        newNome = cliente.getNome();

        newCpf = cliente.getCpf();

        clienteRepository.updateByCpf(cpf, newNome, newCpf);

    }

    @Override
    public List<ClienteModel> listar(){

        System.out.println("Pegando os clientes do banco...");

        return clienteRepository.findAll();

    }

    @Override
    public List<ClienteModel> consultarByCpf(String cpf){

        System.out.println("Pegando o cliente com cpf:" + cpf);

        return clienteRepository.findByCpf(cpf);
    }

    @Override
    public void deletarByCpf(String cpf){

        clienteRepository.removeClienteModelByCpf(cpf);
    }

}
