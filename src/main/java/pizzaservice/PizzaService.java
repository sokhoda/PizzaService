package pizzaservice;

import domain.Pizza;
import domain.PizzaType;

import java.util.List;

public interface PizzaService {
    Pizza save(Pizza pizza);

    Pizza find(Long id);

    List<Pizza> findAll();

    List<Pizza> findByType(PizzaType type);
}
