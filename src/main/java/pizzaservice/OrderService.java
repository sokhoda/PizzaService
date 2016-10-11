package pizzaservice;

import domain.Customer;
import domain.Order;
import org.springframework.context.ApplicationContext;

public interface OrderService {
    Order placeNewOrder(Customer customer, Long... pizzasID);

    void setApplicationContext(ApplicationContext applicationContext);

    Order addPizzas(Order order, Long... idNoPair);

    Double calcDiscountByPizzaQuantity(Order order);

    Double calcDiscountByLCardPercentage(Order order);
}
