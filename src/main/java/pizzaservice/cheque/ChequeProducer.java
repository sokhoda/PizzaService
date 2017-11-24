package pizzaservice.cheque;

import businessdomain.Cheque;
import businessdomain.Orders;
import businessdomain.Pizza;

import java.util.Map;

public interface ChequeProducer {

    Cheque placeCheque(Map<Pizza, Integer> orderedPizzas);
}
