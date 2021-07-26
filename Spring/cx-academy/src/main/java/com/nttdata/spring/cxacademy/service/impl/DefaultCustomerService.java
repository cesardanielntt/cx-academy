package com.nttdata.spring.cxacademy.service.impl;

import com.nttdata.spring.cxacademy.dao.CustomerDao;
import com.nttdata.spring.cxacademy.model.CustomerModel;
import com.nttdata.spring.cxacademy.model.ProductModel;
import com.nttdata.spring.cxacademy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DefaultCustomerService implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<CustomerModel> getAllCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void saveCustomer(CustomerModel customer) {
        if (customer != null){
            customerDao.save(customer);
        }
    }

    @Override
    public CustomerModel getCustomerByCod(Integer customerCod) {
        if(customerCod != null){
            Optional<CustomerModel> model = customerDao.findById(customerCod);
            return model.orElse(null);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Integer customerCod) {
        customerDao.deleteById(customerCod);
    }
}
