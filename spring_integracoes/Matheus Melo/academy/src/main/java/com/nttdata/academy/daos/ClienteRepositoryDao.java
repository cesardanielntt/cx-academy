package com.nttdata.academy.daos;

import com.nttdata.academy.models.ClienteModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;


@Repository
public interface ClienteRepositoryDao extends JpaRepository<ClienteModels, Integer>{

}