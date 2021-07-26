package com.nttdata.spring.cxacademy.facade;

import com.nttdata.spring.cxacademy.data.CustomerData;
import com.nttdata.spring.cxacademy.model.CustomerModel;

import java.util.List;

public interface CustomerFacade {

    List<CustomerData> getAllCustomers();

    void saveCustomer(CustomerData customer);

    CustomerData getCustomerByCode(Integer customerCode);

    void deleteCustomer(Integer customerCode);
}
