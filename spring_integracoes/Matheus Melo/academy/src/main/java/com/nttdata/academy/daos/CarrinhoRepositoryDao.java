package com.nttdata.academy.daos;

import com.nttdata.academy.models.CarrinhoModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepositoryDao extends JpaRepository<CarrinhoModels, Integer> {
}
