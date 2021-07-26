package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.facade.CustomerFacade;
import com.nttdata.spring.cxacademy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.model.CustomerModel;

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
                CustomerData data = convert(customer, new CustomerData());
                customerDatas.add(data);

        }
        return customerDatas;
    }

    @Override
    public void saveCustomers(CustomerData customer){
        if (customer != null) {
            CustomerModel model = reverseConvert(customer, new CustomerModel());
            customerService.saveCustomers(model);
        }
    }
    @Override
    public CustomerData getCustomerByCode(Integer customerCode) {
        CustomerModel model = customerService.getCustomerByCode(customerCode);
        if(model != null){
            return convert(model , new CustomerData());
        }

        return null;
    }
    @Override
    public void deleteCustomer(Integer customerCode){
        customerService.deleteCustomer(customerCode);
    }

    private CustomerData convert(CustomerModel source, CustomerData target){
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());
        target.setStreet(source.getStreet());
        target.setNumber(source.getNumber());
        target.setComplement(source.getComplement());
        target.setCep(source.getCep());
        target.setCity(source.getCity());
        target.setState(source.getState());
        target.setAvailableOnline(source.isAvailableOnline());
        return target;
    }
    private CustomerModel reverseConvert(CustomerData source, CustomerModel target){
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());
        target.setStreet(source.getStreet());
        target.setNumber(source.getNumber());
        target.setComplement(source.getComplement());
        target.setCep(source.getCep());
        target.setCity(source.getCity());
        target.setState(source.getState());
        target.setAvailableOnline(source.isAvailableOnline());
        return target;

    }
}



