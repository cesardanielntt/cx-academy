package com.nttdata.spring.dao;

import com.nttdata.spring.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<ProductModel, Integer> {

    List<ProductModel> findAll();

}
