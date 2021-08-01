package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.ClientData;

import java.util.List;

public interface ClientFacade {
    List<ClientData> getAllClients();

    void saveClient(ClientData client);

    ClientData getClientByCode(Integer clientCode);

    void deleteClient(Integer clientCode);
}
