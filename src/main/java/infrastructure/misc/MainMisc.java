package infrastructure.misc;


import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.http.HttpEntity;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.max;

@DiscriminatorColumn(name = "MISC_TYPE")
public class MainMisc implements Cloneable {
    private int size;


    @Override
    public MainMisc clone() throws CloneNotSupportedException {
        return (MainMisc) super.clone();
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(1);

        Bike bike = new Bike("true");

        System.out.println(new Bike(1, "de"));

        System.out.println("bike.equals(vehicle) = " + bike.equals(vehicle));

        System.out.println("vehicle.equals(bike) = " + vehicle.equals(bike));

        Bird bird = new Pigeon(String.valueOf(new char[]{'b', 'i', 'r', 'd'}));

        Pigeon pigeon = new Pigeon("pigeon");

        AbstractQueue dd;
        System.out.println(bird.color);
        System.out.println(pigeon.color);

        System.out.println(bird.getColor());
        System.out.println(pigeon.getColor());
        new ArrayList().trimToSize();
        new HashMap().values();
        new Bird().fly();
        pigeon.fly();
        long hh = 1;
        Integer d1 = 1;
        Integer d2 = 1;
        System.out.println("d1==d2:" + (d1 == d2));

        String[] stt[];
        stt = new String[][]{{"1", "2"}, {"3", "4"}};
        System.out.println("stt= \n" + Arrays.toString(stt[0]));
        System.out.println("stt= \n" + Arrays.toString(stt[1]));

        System.out.println(bird.sing() + " " + pigeon.sing());
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
        int a3 = -+(10 - 6 + 3);
        System.out.println(a3);

        AtomicInteger f554;

        Integer intg = 3;
        final int ttw = intg;
        System.out.println(ttw);

        Long ll = 3L;
        System.out.println(new Integer((a = 2)) + "\n" + f);
        int rr = '1';
        System.out.println(rr);
        String aa = new String("hello");
        System.out.println("hello".equals(aa));
        Object obb = new Object();
        System.out.println(obb.toString());
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
        PriorityQueue dad;

        List<Integer> list1 = Arrays.asList(1, 2, 23, 4);
        List<Integer> list2 = new ArrayList<>(list1);
        list2.toArray();
        Iterator<Integer> it = list2.iterator();
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
        Hashtable ht = new Hashtable<>();
        ht.put("1", "1");
        System.out.println("ht=" + ht.contains("1"));

        Boolean b1;
        System.out.println(b1 = new Boolean("tRue"));
        b1 = true;

        System.out.println(max(1, 2));
        HttpServlet kk;
        HttpServletRequest re;
        HttpServletResponse response;
        ServletContext context;
        ContextLoaderListener cv;
        Servlet c;
        BeanPostProcessor ffr;
        ServletContextListener scl;
        Filter fc;
        HttpEntity ded;
        new Boolean(new Boolean(true));
        Long de1 = 2L;
        System.out.println(de1.toString());
        int[][] fefe= new int[2][5];
        System.out.println(fefe.length);
        PageContext vbf;
        TagSupport ff2;
        BodyTagSupport frfrf;
    }

    @PreDestroy
    void frf(Integer vari) {
        vari = new Integer(2);

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
