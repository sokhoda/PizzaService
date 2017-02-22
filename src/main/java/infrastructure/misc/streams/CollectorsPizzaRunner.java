package infrastructure.misc.streams;

import domain.Pizza;
import domain.PizzaType;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class CollectorsPizzaRunner {
    public static void main(String[] args) {

        Pizza pizza1 = new Pizza(1L, "Tomato", 90., PizzaType.VEGETERIAN);
        Pizza pizza2 = new Pizza(2L, "Chicken", 120., PizzaType.MEAT);
        Pizza pizza3 = new Pizza(3L, "Octopus", 125., PizzaType.SEA);
        Pizza pizza4 = new Pizza(4L, "Calamar", 120., PizzaType.SEA);
        Pizza pizza5 = new Pizza(5L, "Cheese", 80., PizzaType.VEGETERIAN);

        Pizza[] pizzas = new Pizza[]{pizza1, pizza2, pizza3, pizza4, pizza5};

        System.out.println("-------\nmax of prizes=" + Arrays.stream(pizzas)
                .collect(maxBy(Comparator.comparingDouble(Pizza::getPrice)))
        );

        System.out.println("-------\nmax of prizes=" + Arrays.stream(pizzas)
                .reduce(BinaryOperator.maxBy(Comparator.comparingDouble(Pizza::getPrice)))
        );

        System.out.println("sum of prizes=" + Arrays.stream(pizzas)
                .map(Pizza::getPrice)
                .reduce(0., Double::sum)
        );

        System.out.println("sum of prizes=" + Arrays.stream(pizzas)
                .collect(reducing(0., Pizza::getPrice, Double::sum))
        );

        System.out.println("-------\nmin of prizes=" + Arrays.stream(pizzas)
                .collect(reducing(BinaryOperator.minBy(Comparator.comparingDouble(Pizza::getPrice))))
        );

        System.out.println("sum of pizzaIds=" + Arrays.stream(pizzas)
                .collect(reducing(0L, Pizza::getPizzaId, Long::sum))
        );

        Map<PizzaType, List<Pizza>> pizzaMap = Arrays.stream(pizzas)
                .collect(groupingBy(Pizza::getType));

        Map<String, List<Pizza>> pizzaMap2 = Arrays.stream(pizzas)
                .collect(groupingBy(
                        pizza -> {
                            if (pizza.getPrice() < 100) {
                                return "inexpensive";
                            }
                            else if (pizza.getPrice() <= 120) {
                                return "medium";
                            }
                            else {
                                return "expensive";
                            }
                        }
                ));
        System.out.println("-------------------------------expensive" +
                "/inexpensive-------------");
        Map<PizzaType, Map<String, List<Pizza>>> pizzaMap3 = Arrays.stream(pizzas)
                .collect(groupingBy(Pizza::getType, groupingBy(
                        pizza -> {
                            if (pizza.getPrice() < 100) {
                                return "inexpensive";
                            }
                            else if (pizza.getPrice() <= 120) {
                                return "medium";
                            }
                            else {
                                return "expensive";
                            }
                        }
                )));

        for (PizzaType type : pizzaMap3.keySet()) {
            System.out.println(type + ":");
            for (String price : pizzaMap3.get(type).keySet()) {
                System.out.println(price + ":" + pizzaMap3.get(type).get(price));
            }
        }
        System.out.println
                ("-------------grouping/groupSize-------------------------");
        Map<PizzaType, Long> pizzaMap4 = Arrays.stream(pizzas)
                .collect(groupingBy(Pizza::getType, counting()));

        for (PizzaType pizzaType : pizzaMap4.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap4.get(pizzaType));
        }

        System.out.println
                ("-------------grouping/the cheapest-------------------------");
        Map<PizzaType, Optional<Pizza>> pizzaMap5 = Arrays.stream(pizzas)
                .collect(groupingBy(Pizza::getType,
                        minBy(Comparator.comparingDouble(Pizza::getPrice))));

        for (PizzaType pizzaType : pizzaMap5.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap5.get(pizzaType));
        }

        System.out.println
                ("-------------grouping/the cheapest,collectingAndThen-------------------------");
        Map<PizzaType, Pizza> pizzaMap6 = Arrays.stream(pizzas)
                .collect(
                        groupingBy(
                                Pizza::getType,
                                collectingAndThen(
                                        minBy(Comparator.comparingDouble(Pizza::getPrice)), Optional::get
                                )
                        )
                );

        for (PizzaType pizzaType : pizzaMap6.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap6.get(pizzaType));
        }


//        System.out.println("group of pizzas=" + pizzaMap2);

    }
}
