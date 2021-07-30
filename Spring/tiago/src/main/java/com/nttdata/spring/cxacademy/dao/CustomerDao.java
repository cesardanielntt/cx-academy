package com.nttdata.spring.cxacademy.dao;

import com.nttdata.spring.cxacademy.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<CustomerModel, Integer> {

    Iterable<CustomerModel> findAll();
}
