package infrastructure.misc;


import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainMisc  implements Cloneable{

    @Override
    public MainMisc clone() throws CloneNotSupportedException {
        return (MainMisc) super.clone();
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();

        Bike bike = new Bike();

        System.out.println("bike.equals(vehicle) = " + bike.equals(vehicle));

        System.out.println("vehicle.equals(bike) = " + vehicle.equals(bike));

        Bird bird = new Pigeon(String.valueOf(new char[] {'b','i','r','d'}));

        Pigeon pigeon = new Pigeon("pigeon");


        System.out.println(bird.color);
        System.out.println(pigeon.color);

        System.out.println(bird.getColor());
        System.out.println(pigeon.getColor());

        char val[] = {'d'};
        char[] val2 = {'d'};
        List<Integer> list = new ArrayList<Integer>(new TreeSet<>());
//System.arraycopy(val,0,val2,0,1);
        Arrays.binarySearch(val,'f');
        Arrays.sort(val);
        List<Number> ns = new ArrayList<>();
        List<Integer> is = new LinkedList<>();
        Collections.copy(ns, is);
        System.out.println(val +"\n" + val2);

        double ff = 3d;
        float f = 31/41;
        int a = 0;
        Long ll = 3L;
        System.out.println(new Integer((a=2)) + "\n" + f);
        int rr= '1';
        System.out.println(rr);
        String aa = new String("hello");
        System.out.println("hello".equals(aa));
        Object obb = null;
        obb.toString();
        RequestDispatcher sff;
        IdentityHashMap v;
        WebApplicationContext de;
        CopyOnWriteArrayList frf;
    }

    long mv(int f){
        return 0;
    }
    int mv(){
        return 0;
    }

    public <T> T generic(T a){
        return a;
    }

}
