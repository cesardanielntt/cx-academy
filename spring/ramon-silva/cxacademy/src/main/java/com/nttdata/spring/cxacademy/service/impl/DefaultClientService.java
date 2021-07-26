package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.ClientDao;
import com.nttdata.spring.cxacademy.model.ClientModel;
import com.nttdata.spring.cxacademy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultClientService implements ClientService {

    @Autowired
    private ClientDao clientDao;


    @Override
    public List<ClientModel> getAllClients() {
        return clientDao.findAll();
    }

    @Override
    public void saveClient(ClientModel client) {
        if(client != null) {
            clientDao.save(client);
        }
    }

    @Override
    public ClientModel getClientByCode(Integer clientCode) {

        if(clientCode != null) {
            Optional<ClientModel> model = clientDao.findById(clientCode);

            return model.orElse(null);
        }

        return null;
    }

    @Override
    public void deleteClient(Integer clientCode) {
        clientDao.deleteById(clientCode);
    }


}
