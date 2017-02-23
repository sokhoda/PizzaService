package infrastructure.misc.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        Comparator<BikeSale> comparator = new Comparator<BikeSale>() {
            @Override
            public int compare(BikeSale o1, BikeSale o2) {
                return o1.getDiscount() -  o2.getDiscount();
            }
        };
        Comparator<BikeSale> comparator2 = Comparator.comparingInt
                (BikeSale::getDiscount).reversed();
        System.out.println(bikeSales.stream()
                .collect(Collectors.maxBy(comparator))
        );

        System.out.println(bikeSales.stream()
                .collect(Collectors.maxBy(comparator2))
        );

        System.out.println(bikeSales.stream()
                .collect(Collectors.summarizingInt(BikeSale::getDiscount))
        );

        System.out.println(bikeSales.stream()
                .map(bs ->String.valueOf(bs.getDiscount()))
                .collect(Collectors.joining())
        );

        System.out.println(bikeSales.stream()
                .map(BikeSale::toString)
                .collect(Collectors.joining("@"))
        );

        System.out.println(bikeSales.stream()
                .collect(Collectors.reducing(0, BikeSale::getDiscount, Integer::sum))
        );

        System.out.println(bikeSales.stream()
                .collect(Collectors.reducing((s1, s2) -> (s1.getDiscount() >
                        s2.getDiscount() ? s1 : s2)))
        );

    }
}
