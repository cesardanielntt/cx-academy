package com.nttdata.academy.populator.impl;

import com.nttdata.academy.dto.ClienteDTO;
import com.nttdata.academy.dto.EnderecoDTO;
import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.model.EnderecoModel;
import com.nttdata.academy.populator.ClientePopulator;
import com.nttdata.academy.service.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("clientePopulator")
public class DefaultClientPopulator implements ClientePopulator {

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public ClienteModel populateClienteModel(ClienteDTO source) {
        ClienteModel cliente = modelMapperService.modelMapper().map(source, ClienteModel.class);

        cliente.setEnderecos(source.getEnderecos().stream().map(e -> populateEnderecoModel(e)).collect(Collectors.toList()));

        return cliente;
    }

    private EnderecoModel populateEnderecoModel(EnderecoDTO endereco) {
        return modelMapperService.modelMapper().map(endereco, EnderecoModel.class);
    }

    @Override
    public ClienteDTO populateClienteDTO(ClienteModel source) {
        ClienteDTO cliente = modelMapperService.modelMapper().map(source, ClienteDTO.class);

        cliente.setEnderecos(source.getEnderecos().stream().map(e -> populateEnderecoDTO(e)).collect(Collectors.toList()));

        return cliente;
    }

    private EnderecoDTO populateEnderecoDTO(EnderecoModel endereco) {
        return modelMapperService.modelMapper().map(endereco, EnderecoDTO.class);
    }


}
