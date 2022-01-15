package com.SpringBatch.repository;

import com.SpringBatch.beans.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction , Long> {
}
