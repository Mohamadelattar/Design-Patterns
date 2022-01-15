package com.SpringBatch.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction  implements Serializable {
    @Id
    private int idTransaction;
    private double montant;
    private Date dateTransaction;
    private Date dateDebit;

    @OneToOne(cascade = {CascadeType.ALL})
    private Compte compte;

}
