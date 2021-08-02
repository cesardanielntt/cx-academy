package com.nttdata.academy.daos;

import com.nttdata.academy.models.ProdutoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositoryDao extends JpaRepository<ProdutoModels, Integer> {
}
