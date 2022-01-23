package Chain;

import Observer.Budget;
import Observer.Demande;

public class ServiceGestion implements Handler{
    private Handler handler;

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }
    @Override
    public void handle(Demande demande, Budget budget) {
        budget.setBudget(budget.getBudget() - budget.getMontantBloque());
        budget.setMontantBloque(0);
        System.out.println("budget : " + budget.getBudget() );
        System.out.println(" montant bloqué : " + budget.getMontantBloque() );
    }
}
