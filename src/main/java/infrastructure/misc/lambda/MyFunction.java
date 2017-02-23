package infrastructure.misc.lambda;

import domain.Pizza;
import infrastructure.misc.streams.CollectorsPizzaRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

public class MyFunction {
    public static void main(String[] args) {
        Pizza[] pizzas = CollectorsPizzaRunner.getPizzas();

        Function<Pizza, Pizza> myFunc = pizza -> {
            pizza.setPrice(pizza.getPrice() * 2);
            return pizza;
        };

        Function<Pizza, Pizza> before = pizza -> {
            pizza.setName(pizza.getName() + "!!");
            return pizza;
        };
        Arrays.stream(pizzas)
                .map(myFunc.compose(before))
                .forEach(System.out::print);

    }
}
