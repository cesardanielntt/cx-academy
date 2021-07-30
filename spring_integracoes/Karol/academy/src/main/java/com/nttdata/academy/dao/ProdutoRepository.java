package com.nttdata.academy.dao;

import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository  extends JpaRepository<ProdutoModel>, Integer> {
}
