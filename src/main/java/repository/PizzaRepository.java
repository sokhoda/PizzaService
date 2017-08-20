package repository;

import domain.Pizza;
import domain.PizzaType;

import java.util.List;

public interface PizzaRepository {
    Pizza find(Long id);

    Pizza read(Long id);

    Pizza save(Pizza pizza);

    List<Pizza> findAll();

    List<Pizza> findByType(PizzaType type);

    void remove(Pizza pizza);
}
