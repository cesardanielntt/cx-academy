package com.nttdata.academy.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<com.nttdata.academy.models.ProdutoModel, Integer> {
}
