package com.nttdata.academy.dao;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDAO extends JpaRepository<ProdutoModel, Integer> {

}
