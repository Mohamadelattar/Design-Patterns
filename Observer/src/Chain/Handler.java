package Chain;

import Observer.Budget;
import Observer.Demande;

public interface Handler {
    void setNextHandler(Handler handler);

    void handle(Demande demande, Budget budget);
}
