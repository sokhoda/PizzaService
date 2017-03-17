package infrastructure.misc.singleTon;

public class SingleTonDoubleCheckedLockingVolatileLazyThreadSafe implements Singleton {
    private static volatile Singleton instance;

    private SingleTonDoubleCheckedLockingVolatileLazyThreadSafe(){}

    public Singleton getInstance(){
        if (instance == null){
            synchronized (SingleTonDoubleCheckedLockingVolatileLazyThreadSafe.class){
                if (instance == null){
                    instance = new SingleTonDoubleCheckedLockingVolatileLazyThreadSafe();
                }
            }
        }
        return instance;
    }
}
