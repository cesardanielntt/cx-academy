package com.nttdata.academy.dao;

import com.nttdata.academy.model.PrecoModel;
import com.nttdata.academy.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecoDAO extends CrudRepository<PrecoModel, Integer> {

    @Query("FROM Preco WHERE cliente.id = :clienteId AND produto.id = :produtoId")
    PrecoModel getPrecoByClienteAndProduto(@Param("clienteId") Integer clienteId, @Param("produtoId") Integer produtoId);

    @Query("FROM Preco p JOIN Cliente c ON c.id = p.cliente.id WHERE p.cliente.id = :clienteId")
    List<PrecoModel> getPrecoByCliente(@Param("clienteId") Integer clienteId);


    //  DELETE QUERIES NOT WORKING FOR NOW

    @Query("DELETE FROM Preco WHERE cliente.id = :clienteId")
    void deletePrecoByCliente(@Param("clienteId") Integer id);

    @Query("DELETE FROM Preco WHERE produto.id = :produtoId")
    void deletePrecoByProduto(@Param("produtoId") Integer id);
}
