package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.AdressData;
import com.nttdata.spring.cxacademy.facade.AdressFacade;
import com.nttdata.spring.cxacademy.model.AdressModel;
import com.nttdata.spring.cxacademy.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultAdressFacade implements AdressFacade {

    @Autowired
    private AdressService adressService;

    @Override
    public List<AdressData> getAllAdress() {
        List<AdressModel> adressModels = adressService.getAllAdress();
        List<AdressData> adressDatas = new ArrayList<>();

        for(AdressModel adress: adressModels){
            AdressData data = convert(adress, new AdressData());
            adressDatas.add(data);
        }
        return adressDatas;
    }

    @Override
    public int saveAdress(AdressData adress) {

        if(adress != null){
            AdressModel model = reverseConvert(adress, new AdressModel());

            int idAdress = adressService.saveAdress(model);

            return idAdress;
        }

        return -1;
    }

    @Override
    public void deleteAdress(Integer adressCode) {
        adressService.deleteAdress(adressCode);
    }

    @Override
    public AdressData getAdressByCode(Integer adressCode) {
        AdressModel model = adressService.getAdressByCode(adressCode);
        if(model != null){
            return convert(model, new AdressData());
        }

        return null;
    }

    private AdressData convert(AdressModel source, AdressData target){

        target.setCode(source.getCode());
        target.setRua(source.getRua());
        target.setNumero(source.getNumero());
        target.setComplemento(source.getComplemento());
        target.setCep(source.getCep());
        target.setCidade(source.getCidade());
        target.setEstado(source.getEstado());

        return target;
    }

    private AdressModel reverseConvert(AdressData source, AdressModel target){

        target.setCode(source.getCode());
        target.setRua(source.getRua());
        target.setNumero(source.getNumero());
        target.setComplemento(source.getComplemento());
        target.setCep(source.getCep());
        target.setCidade(source.getCidade());
        target.setEstado(source.getEstado());

        System.out.println("teste da rua:" + target.getRua());

        return target;
    }
}
