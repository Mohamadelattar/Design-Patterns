package com.SpringBatch.batch;

import com.SpringBatch.beans.Compte;
import com.SpringBatch.beans.Transaction;
import com.SpringBatch.beans.TransactionDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class TransactionProcessor implements ItemProcessor<TransactionDto, Transaction> {

    @Override
    public Transaction process(final TransactionDto transactionDto) throws Exception {
        Transaction transformedTransaction = null;
        try {
            int idTransaction = transactionDto.getIdTransaction();
            double montant = transactionDto.getMontant();
            Date dateTransaction = transactionDto.getDateTransaction();
            int idCompte = transactionDto.getIdCompte();
            Compte transformedCompte = Compte.builder().idCompte(idCompte).solde(20000.00).build();
            transformedCompte.debiter(montant);
            transformedTransaction = new Transaction(idTransaction, montant, dateTransaction, new Date(), transformedCompte);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return transformedTransaction;
    }


}
