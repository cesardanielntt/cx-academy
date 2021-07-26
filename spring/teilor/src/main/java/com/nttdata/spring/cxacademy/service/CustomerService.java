package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    List<CustomerModel> getAllCustomers();

    void saveCustomer(CustomerModel customer);

    CustomerModel getCustomerById(Integer customerId);

    void deleteCustomer(Integer customerId);

}
