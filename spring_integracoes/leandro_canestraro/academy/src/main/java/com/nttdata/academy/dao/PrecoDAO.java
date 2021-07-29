package com.nttdata.academy.dao;

import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrecoDAO extends JpaRepository<PrecoModel, Integer> {

}
