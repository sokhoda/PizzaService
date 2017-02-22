package infrastructure.misc.streams;

import domain.Pizza;
import domain.PizzaType;

import java.util.Arrays;
import static java.util.stream.Collectors.*;


public class CollectorsPizzaRunner {
    public static void main(String[] args) {

    Pizza pizza1 = new Pizza(1L, "Tomato", 90., PizzaType.VEGETERIAN);
    Pizza pizza2 = new Pizza(2L, "Chicken", 120., PizzaType.MEAT);
    Pizza pizza3 = new Pizza(3L, "Octopus", 120., PizzaType.SEA);
    Pizza pizza4 = new Pizza(4L, "Calamar", 120., PizzaType.SEA);
    Pizza pizza5 = new Pizza(5L, "Cheese", 90., PizzaType.VEGETERIAN);

    Pizza[] pizzas = new Pizza[]{pizza1, pizza2, pizza3, pizza4, pizza5};

        System.out.println("sum of prizes=" + Arrays.stream(pizzas)
    .collect(reducing(0., Pizza::getPrice,  Double::sum  ))
        );

        System.out.println("sum of prizes=" + Arrays.stream(pizzas)
    .collect(reducing(0L, Pizza::getPizzaId, Long::sum ))
        );
    }
}
