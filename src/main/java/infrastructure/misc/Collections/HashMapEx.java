package infrastructure.misc.Collections;

import infrastructure.misc.Bird;

import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("vf", 1);
        mp.put("fv", 2);
        System.out.println(mp.put("vf", 4));
//        Map smp = Collections.synchronizedMap(mp);
        Set<Map.Entry<String, Integer>> es =  mp.entrySet();
        Iterator<Map.Entry<String, Integer>> it = es.iterator();
        while(it.hasNext()) {
            Map.Entry<String, Integer> e = it.next();
            System.out.println(e.getKey() + ", " + e.getValue());
//            mp.put("bg", 5);
        }
        mp.get("vf");
        System.out.println(mp);
        Integer t;
        System.out.println(Integer.toBinaryString(t=-3));
        System.out.println(Integer.toBinaryString(t >> 1));
        System.out.println(Integer.toBinaryString(t >>> 1));
        System.out.println(null ==null);

        System.out.println(new Bird("ff").compareTo(new Bird("gtg")));
        System.out.println("F".compareTo("1"));
    }
}
