package com.SpringBatch.batch;

import com.SpringBatch.beans.Transaction;
import com.SpringBatch.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.batch.item.ItemWriter;
import java.util.List;

@Service
public class TransactionWriter implements ItemWriter<Transaction> {

    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public void write(List<? extends Transaction> transactions) throws Exception {
        for(Transaction transaction : transactions){
            transactionRepository.save(transaction);
        }

    }
}