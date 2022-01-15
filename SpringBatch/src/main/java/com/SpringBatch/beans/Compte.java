package com.SpringBatch.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class Compte implements Serializable {
    @Id
    private int idCompte;
    private double solde;

    public void debiter(double montant){
        this.solde=this.solde - montant;
    }

}
