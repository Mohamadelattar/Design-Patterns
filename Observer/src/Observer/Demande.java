package Observer;

import java.util.Observable;
import java.util.Observer;

public class Demande implements Observer {

    private Long id;
    private double montantGlobale;

    public Demande() {
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("observer updated, montant : " + montantGlobale);
    }

    public double getMontantGlobale() {
        return montantGlobale;
    }

    public void setMontantGlobale(double montantGlobale) {
        this.montantGlobale = montantGlobale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
