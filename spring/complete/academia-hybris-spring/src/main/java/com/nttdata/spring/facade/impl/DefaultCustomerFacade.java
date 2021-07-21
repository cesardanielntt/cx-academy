package com.nttdata.spring.facade.impl;

import com.nttdata.spring.data.CustomerData;
import com.nttdata.spring.facade.CustomerFacade;
import com.nttdata.spring.model.CustomerModel;
import com.nttdata.spring.service.CustomerService;
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

        return target;
    }

    private CustomerData convert(CustomerModel source, CustomerData target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setEmail(source.getEmail());

        return target;
    }
}
