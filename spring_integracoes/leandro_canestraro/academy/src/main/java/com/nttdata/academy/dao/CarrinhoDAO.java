package com.nttdata.academy.dao;

import com.nttdata.academy.model.CarrinhoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDAO extends CrudRepository<CarrinhoModel, Integer> {



}
