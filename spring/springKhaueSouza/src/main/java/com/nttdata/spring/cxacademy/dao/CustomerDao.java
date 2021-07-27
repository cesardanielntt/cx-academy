package com.nttdata.spring.cxacademy.dao;

import com.nttdata.spring.cxacademy.model.CustomerModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CrudRepository<CustomerModel, Integer> {

    List<CustomerModel> findAll();

    @Query("SELECT c FROM Customer c where c.email = :email")
    CustomerModel findCustomerByEmail(@Param("email") String email);
}

