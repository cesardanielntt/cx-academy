package com.nttdata.academy.dao;

import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrecoDAO extends CrudRepository<PrecoModel, Integer> {

    String query = "FROM Preco WHERE cliente_id = :clienteId AND produto_id = :produtoId";

    @Query("FROM Preco WHERE cliente_id = :clienteId AND produto_id = :produtoId")
    PrecoModel getPrecoByClienteAndProduto(@Param("clienteId") Integer clienteId, @Param("produtoId") Integer produtoId);
}
