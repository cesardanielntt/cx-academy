package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.ClientModel;

import java.util.List;

public interface ClientService {

    List<ClientModel> getAllClients();

    void saveClient(ClientModel client);

    ClientModel getClientByCode(Integer clientCode);

    void deleteClient(Integer ClientCode);

}
