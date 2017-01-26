package infrastructure.misc;


import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.HttpEntity;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainMisc implements Cloneable {

    @Override
    public MainMisc clone() throws CloneNotSupportedException {
        return (MainMisc) super.clone();
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        Bike bike = new Bike("true");

        System.out.println("bike.equals(vehicle) = " + bike.equals(vehicle));

        System.out.println("vehicle.equals(bike) = " + vehicle.equals(bike));

        Bird bird = new Pigeon(String.valueOf(new char[]{'b', 'i', 'r', 'd'}));

        Pigeon pigeon = new Pigeon("pigeon");


        System.out.println(bird.color);
        System.out.println(pigeon.color);

        System.out.println(bird.getColor());
        System.out.println(pigeon.getColor());

        new Bird().fly();
        pigeon.fly();

        char val[] = {'d'};
        char[] val2 = {'d'};
        List<Integer> list = new ArrayList<Integer>(new TreeSet<>());
//System.arraycopy(val,0,val2,0,1);
        Arrays.binarySearch(val, 'f');
        Arrays.sort(val);
        List<Number> ns = new ArrayList<>();
        List<Integer> is = new LinkedList<>();
        Collections.copy(ns, is);
        System.out.println(val + "\n" + val2);

        double ff = 3d;
        float f = 31 / 41;
        int a = 0;
        Long ll = 3L;
        System.out.println(new Integer((a = 2)) + "\n" + f);
        int rr = '1';
        System.out.println(rr);
        String aa = new String("hello");
        System.out.println("hello".equals(aa));
        Object obb = new Object();
        System.out.println(obb.toString());
        Object obb = new Object();
        obb.toString();
        RequestDispatcher sff;
        IdentityHashMap v;
        WebApplicationContext de;
        CopyOnWriteArrayList frf;
        Map<String, String> map = new HashMap<String, String>(10, 0.5f);
        map.put("1", "fd");
        map.put("1", "1fd");
        Set<Map.Entry<String, String>> es = map.entrySet();
        Iterator<Map.Entry<String, String>> iter = es.iterator();
        Iterable vv;
        Queue cc;
        PriorityQueue dd;

        List<Integer> list1  = Arrays.asList(1,2,23,4);
        List<Integer> list2 = new ArrayList<>(list1);

        Iterator<Integer> it = list2.iterator();
        list2.remove(0);
        it.next();
        it.remove();
        it.hasNext();
//        list1.remove(1);

        ArrayBlockingQueue ed;
        while (iter.hasNext()) {
            Map.Entry<String, String> curr = iter.next();
            iter.remove();
            System.out.println(curr.getKey() + "=" + curr.getValue());
        }
        Set<String> key = map.keySet();
        Collection<String> frff = map.values();
        for (String s : frff) {
            System.out.println(s);
        }
        for (String s : key) {
            System.out.println(s);
        }
        HttpServlet kk;
        HttpServletRequest re;
        HttpServletResponse response;
        ServletContext context;
        ContextLoaderListener ed;
        Servlet c;
        BeanPostProcessor ffr;
        ServletContextListener scl;
        Filter fc;
        HttpEntity ded;
        new Boolean(new Boolean(true));
        int ffvf = ~20;
        Long de1 = 2L;
        System.out.println(de1.toString());


    }

    @PreDestroy
    void frf() {

    }

    @PostConstruct
    void frr() {

    }

    long mv(int f) {
        return 0;
    }

    int mv() {
        return 0;
    }

    public <T> T generic(T a) {
        return a;
    }

}
