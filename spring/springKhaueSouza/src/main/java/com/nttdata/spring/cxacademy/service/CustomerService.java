package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    List<CustomerModel> getAllCustomers();

    void save(CustomerModel customer);

    CustomerModel getCustomerByEmail(String email);

    void deleteCustomer(Integer id);
}
