package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.models.ClienteModel;
import com.nttdata.academy.models.EnderecoModel;
import com.nttdata.academy.populators.ClientePopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("clientePopulator")
public class DefaultClientePopulator  implements ClientePopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ClienteModel populateClienteModel(ClienteDTO clienteDTO) {
        ClienteModel cliente = modelMapperService.modelMapper().map(clienteDTO, ClienteModel.class);

        cliente.setEnderecos(clienteDTO.getEnderecos()
                .stream()
                .map(e -> populateEnderecoModel(e)).collect(Collectors.toList()));

        return cliente;
    }

    private EnderecoModel populateEnderecoModel(EnderecoDTO endereco) {
        return modelMapperService.modelMapper().map(endereco, EnderecoModel.class);
    }

    @Override
    public ClienteDTO populateClienteDTO(ClienteModel cliente) {
        ClienteDTO clienteDTO = modelMapperService.modelMapper().map(cliente, ClienteDTO.class);
        clienteDTO.setEnderecos(cliente.getEnderecos()
                .stream()
                .map(e -> populateEnderecoDTO(e)).collect(Collectors.toList()));
        return clienteDTO;
    }

    private EnderecoDTO populateEnderecoDTO(EnderecoModel endereco) {
        return modelMapperService.modelMapper().map(endereco, EnderecoDTO.class);
    }

}
