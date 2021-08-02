package com.nttdata.academy.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<com.nttdata.academy.models.ClienteModel, Integer> {

}
