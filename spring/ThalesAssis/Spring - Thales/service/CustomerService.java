package com.nttdata.spring.cxacademy.service;

import com.nttdata.spring.cxacademy.model.CustomerModel;

import java.util.List;

public interface CustomerService {

    <CustomerModel> List<CustomerModel> getAllCustomers();

    void saveCustomer (CustomerModel costumer);

    CustomerModel getCustomerByCode(Integer CustomerCode);

    void deleteCustomer(Integer customerCode);



}
