package Chain;

import Observer.Budget;
import Observer.Demande;

public class ServiceComptable implements Handler{
    private Handler handler;

    @Override
    public void setNextHandler(Handler handler) {
        this.handler = handler;
    }


    @Override
    public void handle(Demande demande, Budget budget) {
        if (demande.getMontantGlobale() <= budget.getBudget()) {
            budget.setMontantBloque(demande.getMontantGlobale());
            System.out.println("Montant bloque : " + budget.getMontantBloque());
            handler.handle(demande, budget);

        } else {
            System.out.println("Budget insuffisant !");
        }

    }
}
