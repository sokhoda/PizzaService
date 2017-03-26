package infrastructure.misc.streams;

import java.util.*;
//import java.util.function.BinaryOperator;

import static java.util.stream.Collectors.*;

public class CollectorsRunner {
    public static void main(String[] args) {


        BikeSale sale1 = new BikeSale(10, 11);
        BikeSale sale2 = new BikeSale(20, 2);
        BikeSale sale3 = new BikeSale(30, 43);
        BikeSale sale4 = new BikeSale(40, 33);
        List<BikeSale> bikeSales = new ArrayList<>(Arrays.asList(sale1,
                sale2, sale3, sale4));

        Set<BikeSale> bikeSaleSet = new HashSet<>();
        bikeSaleSet.addAll(bikeSales);

        Comparator<BikeSale> comparator = (o1, o2) -> o1.getDiscount() - o2.getDiscount();
        Comparator<BikeSale> comparator2 = Comparator.comparingInt(BikeSale::getDiscount).reversed();

        System.out.println("max by discount =" + bikeSales.stream()
                .collect(maxBy(comparator))
        );

        System.out.println("max by discount reversed =" + bikeSales.stream()
                .collect(maxBy(comparator2))
        );

        System.out.println("summarizingInt=\n" + bikeSales.stream()
                .collect(
                        summarizingInt(BikeSale::getDiscount)
                )
        );

        System.out.println(bikeSales.stream()
                .map(bs -> String.valueOf(bs.getDiscount()))
                .collect(
                        joining()
                )
        );

        System.out.println(bikeSales.stream()
                .map(BikeSale::toString)
                .collect(
                        joining("@")
                )
        );

        System.out.println(bikeSales.stream()
                .collect(
                        reducing(0, BikeSale::getDiscount, Integer::sum)
                )
        );

        System.out.println(bikeSales.stream()
                .collect(
                        reducing((s1, s2) -> (s1.getDiscount() > s2.getDiscount() ? s1 : s2))
                )
        );

        new Random().ints(50, 100).limit(10).forEach(System.out::println);
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 15));
        System.out.println(arr.stream().
                collect(minBy(Comparator.comparingInt(i -> i))).orElse(0));

        System.out.println(
                Arrays.stream(new Integer[]{}).
                        collect(
                                minBy(
                                        Comparator.comparingInt(i -> i)
                                )
                        ).orElseGet(()->11)
        );

        System.out.println(
                Arrays.stream(new Integer[]{10, 14, 245}).
                        collect(
                                toMap( String::valueOf, i -> i)
                        )
        );

    }
}
