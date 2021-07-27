package com.nttdata.academy.dao;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoDAO extends CrudRepository<ProdutoModel, Integer> {

}
