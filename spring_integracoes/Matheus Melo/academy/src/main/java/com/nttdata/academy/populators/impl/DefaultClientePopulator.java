package com.nttdata.academy.populators.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.models.ClienteModels;
import com.nttdata.academy.models.EnderecoModels;
import com.nttdata.academy.populators.ClientePopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service("clientePopulator")
public class DefaultClientePopulator implements ClientePopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ClienteModels populateClienteModel(ClienteDTO clienteDTO) {
        ClienteModels cliente = modelMapperService.modelMapper().map(clienteDTO, ClienteModels.class);
        cliente.setEnderecos(clienteDTO.getEnderecos().stream().map(e -> populateEnderecoModel(e)).collect(Collectors.toList()));

        return cliente;
    }

    private EnderecoModels populateEnderecoModel(EnderecoDTO endereco) {
        return modelMapperService.modelMapper().map(endereco, EnderecoModels.class);
    }

    @Override
    public ClienteDTO populateClienteDTO(ClienteModels cliente) {
        ClienteDTO clienteDTO = modelMapperService.modelMapper().map(cliente, ClienteDTO.class);
        clienteDTO.setEnderecos(cliente.getEnderecos().stream().map(e -> populateEnderecoDTO(e)).collect(Collectors.toList()));

        return clienteDTO;
    }

    private EnderecoDTO populateEnderecoDTO(EnderecoModels endereco) {
        return modelMapperService.modelMapper().map(endereco, EnderecoDTO.class);
    }
}