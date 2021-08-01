package com.nttdata.spring.cxacademy.facade.impl;

import com.nttdata.spring.cxacademy.data.AddressData;
import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.facade.CustomerFacade;
import com.nttdata.spring.cxacademy.model.AddressModel;
import com.nttdata.spring.cxacademy.model.CustomerModel;
import com.nttdata.spring.cxacademy.service.CustomerService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultCustomerFacade implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Override
    public List<CustomerData> getAllCustomers() {
        List<CustomerModel> customerModels = customerService.getAllCustomers();
        List<CustomerData> customerDatas = new ArrayList<>();

        for (CustomerModel customer : customerModels){
            CustomerData data = convert(customer, new CustomerData());
            customerDatas.add(data);
        }

        return customerDatas;
    }

    @Override
    public void saveCustomer(CustomerData customer) {
        if (customer != null){
            CustomerModel model = reverseConvert(customer, new CustomerModel());
            customerService.saveCustomer(model);
        }
    }

    @Override
    public CustomerData getCustomerById(Integer customerId) {
        CustomerModel model = customerService.getCustomerById(customerId);
        if (model != null){
            return convert(model, new CustomerData());
        }
        return null;
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerService.deleteCustomer(customerId);
    }

    private CustomerModel reverseConvert(CustomerData source, CustomerModel target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());

        if (CollectionUtils.isNotEmpty(source.getAddresses())) {
            target.setAddresses(source.getAddresses().stream().map(address -> reverseConvert(address, new AddressModel())).collect(Collectors.toList()));
        }

        return target;
    }

    private CustomerData convert(CustomerModel source, CustomerData target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEmail(source.getEmail());

        if (CollectionUtils.isNotEmpty(source.getAddresses())) {
            target.setAddresses(source.getAddresses().stream().map(address -> convert(address, new AddressData())).collect(Collectors.toList()));
        }

        return target;
    }

    private AddressData convert(AddressModel source, AddressData target){
        target.setId(source.getId());
        target.setStreetName(source.getStreetName());
        target.setStreetNumber(source.getStreetNumber());
        target.setAddressLine2(source.getAddressLine2());
        target.setZipCode(source.getZipCode());
        target.setCity(source.getCity());
        target.setState(source.getState());

        return target;
    }

    private AddressModel reverseConvert(AddressData source, AddressModel target){
        target.setId(source.getId());
        target.setStreetName(source.getStreetName());
        target.setStreetNumber(source.getStreetNumber());
        target.setAddressLine2(source.getAddressLine2());
        target.setZipCode(source.getZipCode());
        target.setCity(source.getCity());
        target.setState(source.getState());

        return target;
    }

}
