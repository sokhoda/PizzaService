package infrastructure.misc.streams;

import infrastructure.misc.Pigeon;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.*;

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

        System.out.println("\n" + Stream.of(new String[]{"Hello", "World"})
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList())
        );

        System.out.println(Arrays.toString("abcsd".split("")));

        System.out.println(bikeSaleSet.stream().anyMatch(s -> s.getDiscount() < 0));
        System.out.println(bikeSaleSet.stream().allMatch(s -> s.getDiscount() > 0));

        System.out.println(bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() > 1)
                .findAny()
                .orElse(sale4)
        );

        System.out.println(bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() < 12)
                .findFirst()
                .orElse(null)
        );
        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() > 10)
                .map(BikeSale::getInternalNo)
                .reduce(0, (i, j) -> i + j)
        );
        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() > 10)
                .map(BikeSale::getInternalNo)
                .reduce(0, Integer::sum)
        );
        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() > 10)
                .map(BikeSale::getInternalNo)
                .reduce(Integer::sum)
        );
        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() > 10)
                .map(BikeSale::getInternalNo)
                .reduce(Integer::max)
        );

        System.out.println("sum internalNo > 12 = " + bikeSaleSet.stream()
                .filter(s -> s.getInternalNo() > 10)
                .mapToInt(BikeSale::getInternalNo)
                .average()
        );
        if (false) {
            IntStream.range(1, 100)
                    .mapToDouble(i -> i / 10.)
                    .forEach(System.out::println);

            BikeSale[] arr = new BikeSale[]{sale1, sale2, sale3, sale4};
            System.out.println("array=" + Arrays.toString(arr));
            Arrays.stream(arr)
                    .sorted()
                    .forEach(System.out::print);

            System.out.println(Arrays.stream(new int[]{10, 20, 30}).sum());

            Stream.iterate(0, i -> i + 2)
                    .map(i -> new int[]{i, i})
                    .limit(5)
                    .forEach(a -> System.out.println(a[0] + ", " + a[1]));

            Stream.iterate(new int[]{0, 1}, a -> new int[]{a[1], a[0] + a[1]})
                    .limit(40)
                    .forEach(a -> System.out.println(Arrays.toString(a) + ", "));


            Node node = new Node();
            Stream.generate(node.value)
                    .limit(20)
                    .forEach(System.out::print);

            System.out.println(Stream.iterate(0, i -> i + 2)
                    .map(String::valueOf)
                    .limit(20)
                    .collect(Collectors.joining())
            );
        }
    }
}
