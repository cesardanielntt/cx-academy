package com.nttdata.academy.dao;

import com.nttdata.academy.model.ClienteModel;
import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends JpaRepository<ClienteModel, Integer> {

    @Override
    ClienteModel getById(Integer integer);
}
