package com.nttdata.academy.dao;

import com.nttdata.academy.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<ClienteModel, Integer> {
}
