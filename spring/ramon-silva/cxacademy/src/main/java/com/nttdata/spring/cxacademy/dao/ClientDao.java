package com.nttdata.spring.cxacademy.dao;

import com.nttdata.spring.cxacademy.model.ClientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends CrudRepository<ClientModel, Integer> {
    List<ClientModel> findAll();
}
