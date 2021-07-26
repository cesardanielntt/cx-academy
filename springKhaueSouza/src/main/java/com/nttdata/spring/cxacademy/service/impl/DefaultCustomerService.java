package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.CustomerDao;
import com.nttdata.spring.cxacademy.model.CustomerModel;
import com.nttdata.spring.cxacademy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void save(CustomerModel customer) {
        if (customer != null) {
            customerDao.save(customer);
        } else {
            System.out.println("Customer is null");
        }
    }

    @Override
    public CustomerModel getCustomerByEmail(String email) {
        if (email != null) {
            return customerDao.findCustomerByEmail(email);
        }

        return null;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerDao.deleteById(id);
    }
}
