package com.nttdata.academy.daos;

import com.nttdata.academy.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    List<ClienteModel> findByCpf(String cpf);

    void removeClienteModelByCpf(String cpf);

}
