package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.AddressData;
import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.facade.CustomerFacade;
import com.nttdata.spring.cxacademy.model.AddressModel;
import com.nttdata.spring.cxacademy.model.CustomerModel;
import com.nttdata.spring.cxacademy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultCustomerFacade implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Override
    public List<CustomerData> getAllCustomers() {
        List<CustomerModel> customerModels = customerService.getAllCustomers();

        List<CustomerData> customerDatas = new ArrayList<>();

        for(CustomerModel customer: customerModels){
            CustomerData data = convert(customer, new CustomerData());
            customerDatas.add(data);
        }
        return customerDatas;
    }

    @Override
    public void save(CustomerData customer) {

        if(customer != null){

            CustomerModel model = reverseConvert(customer, new CustomerModel());

            customerService.saveCustomer(model);
        }
    }

    @Override
    public CustomerData getCustomerByCode(int customerCode) {
        CustomerModel model = customerService.getCustomerByCode(customerCode);
        if(model != null){
            return convert(model, new CustomerData());
        }

        return null;
    }

    @Override
    public void deleteCustomer(int customerCode) {
        customerService.deleteCustomer(customerCode);
    }

    private CustomerData convert(CustomerModel source, CustomerData target){

        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setSobrenome(source.getSobrenome());
        target.setEmail(source.getEmail());

        List<AddressData> enderecosD = new ArrayList<>(); // target

        List<AddressModel> enderecosM = source.getEnderecos(); // source


        for(AddressModel address: enderecosM){

            AddressData addressData = new AddressData();

            addressData.setRua(address.getRua());
            addressData.setNumero(address.getNumero());
            addressData.setComplemento(address.getComplemento());
            addressData.setCidade(address.getCidade());
            addressData.setEstado(address.getEstado());
            addressData.setCep(address.getCep());

            enderecosD.add(addressData);

        }

        target.setEnderecos(enderecosD);

        return target;
    }

    private CustomerModel reverseConvert(CustomerData source, CustomerModel target){

        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setSobrenome(source.getSobrenome());
        target.setEmail(source.getEmail());
        
        List<AddressData> enderecos = source.getEnderecos();

        List<AddressModel> enderecosM = new ArrayList<>();


        for(AddressData address: enderecos){

            AddressModel addressModel = new AddressModel();

            addressModel.setRua(address.getRua());
            addressModel.setNumero(address.getNumero());
            addressModel.setComplemento(address.getComplemento());
            addressModel.setCidade(address.getCidade());
            addressModel.setEstado(address.getEstado());
            addressModel.setCep(address.getCep());

            enderecosM.add(addressModel);

        }

        target.setEnderecos(enderecosM);



        return target;
    }
}
