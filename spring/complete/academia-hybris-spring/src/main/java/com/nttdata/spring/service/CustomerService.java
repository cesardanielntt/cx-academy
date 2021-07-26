package com.nttdata.spring.service;

import com.nttdata.spring.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    List<CustomerModel> getAllCustomers();

    void save(CustomerModel customer);

    CustomerModel getCustomerByEmail(String email);

    void deleteCustomer(Integer id);
}
