package infrastructure.misc.singleTon;

public class SingleTonNonLazyThreadSafe implements Singleton {
    private static Singleton instance = new SingleTonNonLazyThreadSafe();

    private SingleTonNonLazyThreadSafe(){}

    public static Singleton getInstance(){
        return instance;
    }
}
