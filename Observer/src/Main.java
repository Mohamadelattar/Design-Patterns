import Chain.Handler;
import Chain.ServiceComptable;
import Chain.ServiceGestion;
import Observer.Budget;
import Observer.Demande;

public class Main {
    public static void main(String[] args) {
        Budget budget = new Budget();
        Handler serviceComptable = new ServiceComptable();
        Handler serviceGestion = new ServiceGestion();
        serviceComptable.setNextHandler(serviceGestion);

        Demande demande1 = new Demande();
        Demande demande2 = new Demande();

        budget.setBudget(20000);
        demande1.setMontantGlobale(5000);
        demande2.setMontantGlobale(7000);

        budget.addObserver(demande1);
        budget.addObserver(demande2);
        budget.notifyDemande();
        serviceComptable.handle(demande1, budget);
        serviceComptable.handle(demande2, budget);
        budget.notifyDemande();


    }
}
