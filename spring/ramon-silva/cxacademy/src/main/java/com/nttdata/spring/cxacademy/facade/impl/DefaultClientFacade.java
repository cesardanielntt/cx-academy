package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.ClientData;
import com.nttdata.spring.cxacademy.facade.ClientFacade;
import com.nttdata.spring.cxacademy.model.ClientModel;
import com.nttdata.spring.cxacademy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultClientFacade implements ClientFacade {

    @Autowired
    private ClientService clientService;

    @Override
    public List<ClientData> getAllClients() {
        List<ClientModel> clientModels = clientService.getAllClients();
        List<ClientData> clientDatas = new ArrayList<>();

        for (ClientModel client : clientModels) {
            ClientData data = convert(client, new ClientData());
            clientDatas.add(data);
        }

        return clientDatas;

    }

    @Override
    public void saveClient(ClientData client) {
        if(client != null) {
            ClientModel model = reverseConvert(client, new ClientModel());
            clientService.saveClient(model);
        }
    }

    @Override
    public ClientData getClientByCode(Integer clientCode) {
        ClientModel model = clientService.getClientByCode(clientCode);

        if(model != null) {
            return convert(model, new ClientData());
        }

        return null;
    }

    @Override
    public void deleteClient(Integer clientCode) {
        clientService.deleteClient(clientCode);
    }

    private ClientData convert(ClientModel source, ClientData target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());
        target.setNameStreet(source.getNameStreet());
        target.setNumberStreet(source.getNumberStreet());
        target.setComplement(source.getComplement());
        target.setCep(source.getCep());
        target.setCity(source.getCity());
        target.setUf(source.getUf());

        return target;
    }

    private ClientModel reverseConvert(ClientData source, ClientModel target) {
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());
        target.setNameStreet(source.getNameStreet());
        target.setNumberStreet(source.getNumberStreet());
        target.setComplement(source.getComplement());
        target.setCep(source.getCep());
        target.setCity(source.getCity());
        target.setUf(source.getUf());

        return target;
    }


}
