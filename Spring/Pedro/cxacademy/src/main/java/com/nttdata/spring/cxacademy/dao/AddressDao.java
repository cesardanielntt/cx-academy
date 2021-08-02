package com.nttdata.spring.cxacademy.dao;

import com.nttdata.spring.cxacademy.model.AddressModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends CrudRepository<AddressModel, Integer> {

    @Override
    List<AddressModel> findAll();
}
