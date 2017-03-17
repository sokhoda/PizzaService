package infrastructure.misc.singleTon;

public class SingleTonLazySlowThreadSafe implements Singleton{
    private static Singleton instance;

    private SingleTonLazySlowThreadSafe(){}

    public static synchronized Singleton getInstance(){
        if (instance == null){
            instance = new SingleTonLazySlowThreadSafe();
        }
        return instance;
    }
}
