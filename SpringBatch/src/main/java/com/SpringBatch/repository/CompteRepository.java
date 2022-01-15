package com.SpringBatch.repository;

import com.SpringBatch.beans.Compte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends CrudRepository<Compte,Integer> {
}
