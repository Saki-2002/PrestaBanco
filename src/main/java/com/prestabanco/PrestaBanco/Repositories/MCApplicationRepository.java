package com.prestabanco.PrestaBanco.Repositories;

import com.prestabanco.PrestaBanco.Entities.MCApplicationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MCApplicationRepository extends JpaRepository<MCApplicationEntity, Long> {

    //

}
