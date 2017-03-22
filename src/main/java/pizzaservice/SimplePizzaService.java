package pizzaservice;

import domain.Pizza;
import domain.PizzaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.JPAPizzaRepo;
import repository.PizzaRepository;

import java.util.List;

@Service("pizzaService")
public class SimplePizzaService implements PizzaService {

    @Autowired
    @Qualifier(value = "pizzaRepository")
    private PizzaRepository pizzaRepo;

    public SimplePizzaService() {
    }

    public SimplePizzaService(PizzaRepository pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }

    @Transactional
    @Override
    public Pizza save(Pizza pizza) {
        return pizzaRepo.save(pizza);
    }

    @Override
    public Pizza find(Long id) {
        return pizzaRepo.find(id);
    }

    @Override
    public List<Pizza> findAll() {
        return pizzaRepo.findAll();
    }

    @Override
    public List<Pizza> findByType(PizzaType type) {
        return pizzaRepo.findByType(type);
    }

    public static Pizza getVegetarianPizza(){
        return new Pizza(null, "Vege", 123., PizzaType.VEGETERIAN);
    }

    public final Pizza finalMethod(){
        return new Pizza();
    }

    public Pizza methodWithConstructor(Long id){
        PizzaRepository repo = new JPAPizzaRepo();
        return repo.find(id);
    }

    public Pizza privateMethodCaller(){
        return privateGetPizza(1L);
    }

    private Pizza privateGetPizza(Long id){
        final Pizza pizza = new Pizza();
        pizza.setPizzaId(1L);
        return pizza;
    }
}
