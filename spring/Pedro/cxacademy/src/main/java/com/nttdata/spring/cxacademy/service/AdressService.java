package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.AdressModel;

import java.util.List;

public interface AdressService {

    List<AdressModel> getAllAdress();

    int saveAdress(AdressModel adress);

    AdressModel getAdressByCode(Integer adressCode);

    void deleteAdress(Integer adressCode);
}
