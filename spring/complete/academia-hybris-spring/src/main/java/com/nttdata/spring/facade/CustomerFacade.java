package com.nttdata.spring.facade;

import com.nttdata.spring.data.CustomerData;

import java.util.List;

public interface CustomerFacade {

    List<CustomerData> getAllCustomers();

    void saveCustomer(CustomerData customer);

    CustomerData getCustomerByEmail(final String email);

    void deleteCustomer(Integer id);
}
