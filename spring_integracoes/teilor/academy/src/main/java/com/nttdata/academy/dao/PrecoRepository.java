package com.nttdata.academy.dao;

import com.nttdata.academy.models.PrecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoRepository extends JpaRepository<PrecoModel, Integer> {
}
