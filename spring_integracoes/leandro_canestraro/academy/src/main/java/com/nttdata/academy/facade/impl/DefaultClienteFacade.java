package com.nttdata.academy.facade.impl;

import com.nttdata.academy.dao.ClienteDAO;
import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.facade.ClienteFacade;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.populator.ClientePopulator;
import com.nttdata.academy.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//Communication between Controller and Service layers

@Service("clienteFacade")
public class DefaultClienteFacade implements ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientePopulator clientePopulator;


    //Call service to insert data on db
    @Override
    public ClienteDTO adicionar(ClienteDTO source) {


        //Populator to convert objects
        ClienteModel cliente = clienteService
                .saveCliente(clientePopulator
                        .populateClienteModel(source));

        source = clientePopulator.populateClienteDTO(cliente);

        return source;
    }

    //Call service to retrieve a registry on db
    @Override
    public ClienteModel getClienteById(Integer id) {
        return clienteService.getClienteById(id);
    }

    @Override
    public List<ClienteDTO> getClientes() {

        List<ClienteDTO> target = new ArrayList<>();

        List<ClienteModel> clientes = clienteService.getClientes();

        for (ClienteModel cliente : clientes) {
            target.add(clientePopulator.populateClienteDTO(cliente));
        }

        return target;
    }

    @Override
    public String deleteCliente(Integer id) {

        try {
            clienteService.deleteCliente(id);
        } catch (Exception e) {
            return "Erro ao deletar cliente: " + e.getMessage();
        }
        return "Cliente deletado com sucesso (precos relacionados ao cliente tambem foram deletados)";
    }
}
