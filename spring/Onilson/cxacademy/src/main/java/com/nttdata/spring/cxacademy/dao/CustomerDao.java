package com.nttdata.spring.cxacademy.dao;



import com.nttdata.spring.cxacademy.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CrudRepository<CustomerModel, Integer> {

    List<CustomerModel> findAll();

}

