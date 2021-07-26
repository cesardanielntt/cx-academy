package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.AdressData;
import com.nttdata.spring.cxacademy.data.CustomerData;

import java.util.List;

public interface AdressFacade {

    List<AdressData> getAllAdress();

    int saveAdress(AdressData adress);

    AdressData getAdressByCode(Integer adressCode);

    void deleteAdress(Integer adressCode);

}
