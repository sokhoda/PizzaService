package infrastructure.misc.lambda;

import com.sun.org.apache.regexp.internal.RE;
import domain.PizzaType;
import infrastructure.misc.Bike;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lamdas {

    interface Start{
        int myValue(int a, String str);
    }

    public static void main(String[] args) {
        IntFunction<String> res = (int i) -> {
            return String.valueOf(i*2);
        };

        Function<Integer, String> keyMapper = i -> String.valueOf(i*2);
        Function<Integer, Integer> valueMapper = i -> i*20;
        Map<String,Integer> mapp = Stream.of(new Integer []{1,2,3}).collect
                (Collectors.toMap(keyMapper, valueMapper) );
//        Collector
        System.out.println("mapp" + mapp.toString());


        Start myVal = (int i, String str) -> i + (str != null ? str.length() : 0);
        System.out.println("myVal=" + myVal.myValue(10, "frferf"));

        System.out.println(res.apply(10));
        Arrays.asList();
        Predicate<Bike> tester = bike -> bike.getModel().contains("est");
        System.out.println(tester.test(new Bike("be1ster")));

        System.out.println(PizzaType.VEGETERIAN.ordinal());
    }

}
