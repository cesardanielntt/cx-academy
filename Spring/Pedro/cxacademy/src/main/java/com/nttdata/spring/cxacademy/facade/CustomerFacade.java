package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.CustomerData;

import java.util.List;

public interface CustomerFacade {

    List<CustomerData> getAllCustomers();

    void save(CustomerData customer);

    CustomerData getCustomerByCode(int customerCode);

    void deleteCustomer(int customerCode);

}
