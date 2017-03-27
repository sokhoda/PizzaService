package infrastructure.misc.streams;

import domain.Pizza;
import domain.PizzaType;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class CollectorsPizzaRunner {

    public static Pizza[] getPizzas() {
        Pizza pizza1 = new Pizza(1L, "Tomato", 90., PizzaType.VEGETERIAN);
        Pizza pizza2 = new Pizza(2L, "Chicken", 120., PizzaType.MEAT);
        Pizza pizza3 = new Pizza(3L, "Octopus", 125., PizzaType.SEA);
        Pizza pizza4 = new Pizza(4L, "Calamar", 120., PizzaType.SEA);
        Pizza pizza5 = new Pizza(5L, "Cheese", 80., PizzaType.VEGETERIAN);

        return new Pizza[]{pizza1, pizza2, pizza3, pizza4, pizza5};
    }

    public static void main(String[] args) {

        Pizza[] pizzas = getPizzas();

        System.out.println("-------\nmax of prizes=" + Arrays.stream(pizzas)
                .collect(maxBy(comparingDouble(Pizza::getPrice)))
        );

        System.out.println("-------\nmax of prizes=" + Arrays.stream(pizzas)
                .reduce(BinaryOperator.maxBy(comparingDouble(Pizza::getPrice)))
        );

        System.out.println("sum of prizes=" + Arrays.stream(pizzas)
                .map(Pizza::getPrice)
                .reduce(0., Double::sum)
        );

        System.out.println("sum of prizes=" + Arrays.stream(pizzas)
                .collect(reducing(0., Pizza::getPrice, Double::sum))
        );

        System.out.println("-------\nmin of prizes=" + Arrays.stream(pizzas)
                .collect(
                        reducing(
                                BinaryOperator.minBy(
                                        comparingDouble(Pizza::getPrice)
                                )
                        )
                )
        );

        System.out.println("sum of pizzaIds=" + Arrays.stream(pizzas)
                .collect(reducing(0L, Pizza::getPizzaId, Long::sum))
        );

        Map<PizzaType, List<Pizza>> pizzaMap = Arrays.stream(pizzas)
                .collect(groupingBy(Pizza::getType));

        Function<Pizza, String> pizzaExpensivenessFunction = pizza -> {
            if (pizza.getPrice() < 100) {
                return "inexpensive";
            }
            else if (pizza.getPrice() <= 120) {
                return "medium";
            }
            else {
                return "expensive";
            }
        };
        Map<String, List<Pizza>> pizzaMap2 = Arrays.stream(pizzas)
                .collect(
                        groupingBy(pizzaExpensivenessFunction)
                );
        System.out.println("pizzaMap2");
        System.out.println(pizzaMap2);

        System.out.println("-------------------------------expensive" +
                "/inexpensive-------------");
        Map<PizzaType, Map<String, List<Pizza>>> pizzaMap3 = Arrays.stream(pizzas)
                .collect(
                        groupingBy(
                                Pizza::getType,
                                groupingBy(pizzaExpensivenessFunction)
                        )
                );

        for (PizzaType type : pizzaMap3.keySet()) {
            System.out.println(type + ":");
            for (String price : pizzaMap3.get(type).keySet()) {
                System.out.println(price + ":" + pizzaMap3.get(type).get(price));
            }
        }
        System.out.println
                ("-------------grouping/groupSize-------------------------");
        Map<PizzaType, Long> pizzaMap4 = Arrays.stream(pizzas)
                .collect(
                        groupingBy(
                                Pizza::getType, counting()
                        )
                );

        for (PizzaType pizzaType : pizzaMap4.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap4.get(pizzaType));
        }

        System.out.println
                ("-------------grouping/the cheapest-------------------------");
        Map<PizzaType, Optional<Pizza>> pizzaMap5 = Arrays.stream(pizzas)
                .collect(
                        groupingBy(
                                Pizza::getType,
                                minBy(comparingDouble(Pizza::getPrice))
                        )
                );

        for (PizzaType pizzaType : pizzaMap5.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap5.get(pizzaType));
        }

        System.out.println
                ("-------------grouping/the cheapest,collectingAndThen-------------------------");
        Map<PizzaType, Pizza> pizzaMap6 = Arrays.stream(pizzas).parallel()
                .collect(
                        groupingBy(
                                Pizza::getType,
                                collectingAndThen(
                                        minBy(comparingDouble(Pizza::getPrice)), Optional::get
                                )
                        )
                );

        for (PizzaType pizzaType : pizzaMap6.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap6.get(pizzaType));
        }

        System.out.println("-------------------------------expensive/inexpensive set-------------");
        Map<PizzaType, Set<String>> pizzaMap7 = Arrays.stream(pizzas)
                .collect(
                        groupingBy(Pizza::getType,
                                mapping(pizzaExpensivenessFunction, toSet())
                        )
                );

        for (PizzaType pizzaType : pizzaMap7.keySet()) {
            System.out.println(pizzaType + ":" + pizzaMap7.get(pizzaType));
        }

        Predicate<Pizza> isExpensive = pizza -> {
            return pizza.getPrice() >= 90.;
        };

        Predicate<Pizza> isVegeterian = pizza -> {
            if (pizza.getType().equals(PizzaType.VEGETERIAN)) {
                return true;
            }
            else {
                return false;
            }
        };

        System.out.println
                ("-------------------------------partitioning isExpensive-------------");
        Map<Boolean, List<Pizza>> pizzaMap8 = Arrays.stream(pizzas)
                .collect(
                        partitioningBy(isExpensive)
                );

        for (Boolean izExpensive : pizzaMap8.keySet()) {
            System.out.println(izExpensive + ":" + pizzaMap8.get(izExpensive));
        }

        System.out.println
                ("-------------------------------partitioning isExpensive and" +
                        " grouping by PizzaType-------------");
        Map<Boolean, Map<PizzaType, List<Pizza>>> pizzaMap9 = Arrays.stream(pizzas)
                .collect(
                        partitioningBy(
                                isExpensive,
                                groupingBy(Pizza::getType)
                        )
                );

        for (Boolean izExpensive : pizzaMap9.keySet()) {
            System.out.println(izExpensive + ":");
            for (PizzaType type : pizzaMap9.get(izExpensive).keySet()) {
                System.out.println(type + ":" + pizzaMap9.get(izExpensive).get(type));
            }
        }

        System.out.println
                ("-------------------------------partitioning isVegeterian and" +
                        " the cheapest-------------");
        Map<Boolean, Pizza> pizzaMap10 = Arrays.stream(pizzas)
                .collect(
                        partitioningBy(
                                isVegeterian,
                                collectingAndThen(
                                        minBy(comparingDouble(Pizza::getPrice)),
                                        Optional::get
                                )
                        )
                );

        for (Boolean izVegeterian : pizzaMap10.keySet()) {
            System.out.println(izVegeterian + ":" + pizzaMap10.get(izVegeterian));
        }

//        System.out.println("group of pizzas=" + pizzaMap2);

//        System.out.println();
        System.out.println
                ("-------------------------------partitioning isPrime-------------");

        Map<Boolean, List<Integer>> primeMap = IntStream.rangeClosed(2, 100)
                .boxed()
                .collect(
                        partitioningBy(CollectorsPizzaRunner::isPrime)
                );

        for (Boolean izVegeterian : primeMap.keySet()) {
            System.out.println(izVegeterian + ":" + primeMap.get(izVegeterian));
        }
    }

    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }
}
