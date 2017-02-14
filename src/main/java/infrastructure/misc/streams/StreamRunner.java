package infrastructure.misc.streams;

import infrastructure.misc.Pigeon;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {
    public static void main(String[] args) {


        BikeSale sale1 = new BikeSale(10, 11);
        BikeSale sale2 = new BikeSale(20, 2);
        BikeSale sale3 = new BikeSale(30, 43);
        BikeSale sale4 = new BikeSale(40, 33);
        List<BikeSale> bikeSales = new ArrayList<>(Arrays.asList(sale1,
                sale2, sale3, sale4));

        Set<BikeSale> bikeSaleSet = new HashSet<>();
        bikeSaleSet.addAll(bikeSales);

        bikeSales.stream()
                .sorted((a, b) -> b.getInternalNo() - a.getInternalNo())
                .map(BikeSale::getInternalNo)
                .forEach(System.out::println);

        List<BikeSale> sales2 = bikeSales.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sales2);

        System.out.print("set");
        bikeSaleSet.stream()
                .filter(s -> s.getDiscount() >= 20)
                .sorted()
                .skip(2)
                .limit(2)
                .forEach(System.out::print);

        System.out.println("\n"+  Stream.of(new String[]{"Hello", "World"})
                    .map(s -> s.split(""))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .collect(Collectors.toList())
        );

        System.out.println(Arrays.toString("abcsd".split("")));

        System.out.println(bikeSaleSet.stream().anyMatch(s -> s.getDiscount() < 0));
        System.out.println(bikeSaleSet.stream().allMatch(s -> s.getDiscount()
                > 0));

        System.out.println(bikeSaleSet.stream()
                .filter( s-> s.getInternalNo() > 1)
                .findAny()
                .orElse(sale4)
        );

        System.out.println(bikeSaleSet.stream()
                .filter( s-> s.getInternalNo() < 12)
                .findFirst()
                .orElse(null)
        );

        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                        .filter( s-> s.getInternalNo() > 10)
                        .map(BikeSale::getInternalNo)
                        .reduce(0, (i, j)-> i + j)
        );

        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                        .filter( s-> s.getInternalNo() > 10)
                        .map(BikeSale::getInternalNo)
                        .reduce(0, Integer::sum)
        );

        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                        .filter( s-> s.getInternalNo() > 10)
                        .map(BikeSale::getInternalNo)
                        .reduce(Integer::sum)
        );

        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                .filter( s-> s.getInternalNo() > 10)
                .map(BikeSale::getInternalNo)
                .reduce(Integer::max)
        );

//                .ifPresent(d-> System.out.println(d.getInternalNo()));

    }
}
