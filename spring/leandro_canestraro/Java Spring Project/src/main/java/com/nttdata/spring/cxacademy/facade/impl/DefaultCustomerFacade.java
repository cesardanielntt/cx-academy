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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultCustomerFacade implements CustomerFacade {

    @Autowired
    private CustomerService customerService;

    @Override
    public List<CustomerData> getAllCustomers() {
        List<CustomerModel> customers = customerService.getAllCustomers();
        if (CollectionUtils.isNotEmpty(customers)) {
            return customers.stream().map(customer -> convert(customer, new CustomerData())).collect(Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public void saveCustomer(CustomerData customer) {
        CustomerModel model = reverseConvert(customer, new CustomerModel());
        customerService.save(model);
    }

    @Override
    public CustomerData getCustomerByEmail(String email) {
        CustomerModel model = customerService.getCustomerByEmail(email);
        if (model != null) {
            return convert(model, new CustomerData());
        }

        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerService.deleteCustomer(id);
    }

    private CustomerModel reverseConvert(CustomerData source, CustomerModel target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setEmail(source.getEmail());

        if (CollectionUtils.isNotEmpty(source.getAddresses())) {
            target.setAddresses(source.getAddresses().stream().map(address -> reverseConvert(address, new AddressModel())).collect(Collectors.toList()));
        }

        return target;
    }

    private CustomerData convert(CustomerModel source, CustomerData target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setEmail(source.getEmail());

        if (CollectionUtils.isNotEmpty(source.getAddresses())) {
            target.setAddresses(source.getAddresses().stream().map(address -> convert(address, new AddressData())).collect(Collectors.toList()));
        }

        return target;
    }

    private AddressModel reverseConvert(AddressData source, AddressModel target) {
        target.setId(source.getId());
        target.setStreetName(source.getStreetName());
        target.setStreetNumber(source.getStreetNumber());
        target.setCity(source.getCity());

        return target;
    }

    private AddressData convert(AddressModel source, AddressData target) {
        target.setId(source.getId());
        target.setStreetName(source.getStreetName());
        target.setStreetNumber(source.getStreetNumber());
        target.setCity(source.getCity());

        return target;
    }
}