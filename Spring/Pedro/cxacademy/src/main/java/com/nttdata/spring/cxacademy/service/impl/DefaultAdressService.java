package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.AdressDao;
import com.nttdata.spring.cxacademy.model.AdressModel;
import com.nttdata.spring.cxacademy.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultAdressService implements AdressService {

    @Autowired
    private AdressDao adressDao;

    @Override
    public List<AdressModel> getAllAdress() {
        return adressDao.findAll();
    }

    @Override
    public int saveAdress(AdressModel adress) {

        if(adress != null){


            adressDao.save(adress);

            return adress.getCode();
        }
        return -1;
    }

    @Override
    public AdressModel getAdressByCode(Integer adressCode) {
        if(adressCode != null){
            Optional<AdressModel> model = adressDao.findById(adressCode);
            return model.orElse(null);
        }
        return null;
    }

    @Override
    public void deleteAdress(Integer adressCode) {
        adressDao.deleteById(adressCode);
    }
}
