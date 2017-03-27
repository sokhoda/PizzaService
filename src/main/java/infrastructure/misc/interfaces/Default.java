package infrastructure.misc.interfaces;

public interface Default {
    default void runner(){
        System.out.println("runner");
    }

    static void stMeth(){
        System.out.println("static");
    }

    int sum(int a, int b);
}
