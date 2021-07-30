package com.nttdata.spring.cxacademy.dao;

import com.nttdata.spring.cxacademy.model.AdressModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressDao extends CrudRepository<AdressModel, Integer> {

    @Override
    List<AdressModel> findAll();
}
