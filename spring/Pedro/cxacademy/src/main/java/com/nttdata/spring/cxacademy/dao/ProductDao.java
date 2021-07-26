package com.nttdata.spring.cxacademy.dao;

import com.nttdata.spring.cxacademy.model.ProductModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<ProductModel, Integer> {

    @Override
    List<ProductModel> findAll();
/*
    @Query("SELECT * FROM product WHERE available_online=true")
    List<ProductModel> findEnabled(); */
}
