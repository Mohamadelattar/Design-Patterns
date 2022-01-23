package Observer;


import java.util.Observable;

public class Budget extends Observable {
    private double budget;
    private double montantBloque;

    public Budget() {}

    public void notifyDemande() {
        setChanged();
        notifyObservers();
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getMontantBloque() {
        return montantBloque;
    }

    public void setMontantBloque(double montantBloque) {
        this.montantBloque = montantBloque;
    }

}
