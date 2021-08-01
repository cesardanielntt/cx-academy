package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.facade.CustomerFacade;
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

        for (CustomerModel customer : customerModels) {
            CustomerData cdata = convert(customer, new CustomerData());
            customerDatas.add(cdata);
        }

        return customerDatas;

    }


    @Override
    public void saveCustomer(CustomerData customer) {
        if (customer !=null) {
            CustomerModel model = reverseConvert(customer, new CustomerModel());
            customerService.saveCustomer(model);
        }

    }

    @Override
    public CustomerData getCustomerByCode(Integer customerCode) {
        CustomerModel model = customerService.getCustomerByCode(customerCode);
        if (model != null) {
            return convert(model, new CustomerData());
        }
        return null;

    }

    @Override
    public void deleteCustomer(Integer customerCode) {
        customerService.deleteCustomer(customerCode);
    }

    private CustomerData convert(CustomerModel source, CustomerData target) {
        target.setCode(source.getCode());
        target.setNome(source.getNome());
        target.setSobrenome(source.getSobrenome());
        target.setEmail(source.getEmail());
        target.setRua(source.getRua());
        target.setNumero(source.getNumero());
        target.setComplemento(source.getComplemento());
        target.setCep(source.getCep());
        target.setCidade(source.getCidade());
        target.setEstado(source.getEstado());
        target.setAvailableOnline(source.isAvailableOnline());
        return target;
    }




    private CustomerModel reverseConvert(CustomerData source, CustomerModel target) {
        target.setCode(source.getCode());
        target.setNome(source.getNome());
        target.setSobrenome(source.getSobrenome());
        target.setEmail(source.getEmail());
        target.setRua(source.getRua());
        target.setNumero(source.getNumero());
        target.setComplemento(source.getComplemento());
        target.setCep(source.getCep());
        target.setCidade(source.getCidade());
        target.setEstado(source.getEstado());
        target.setAvailableOnline(source.isAvailableOnline());

        return target;

    }



}