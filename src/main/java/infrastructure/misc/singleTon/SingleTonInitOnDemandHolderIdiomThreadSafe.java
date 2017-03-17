package infrastructure.misc.singleTon;

public class SingleTonInitOnDemandHolderIdiomThreadSafe implements Singleton {
    private SingleTonInitOnDemandHolderIdiomThreadSafe() {
        System.out.println("constructor invocation");
    }

    public static Singleton getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final Singleton instance = new SingleTonInitOnDemandHolderIdiomThreadSafe();
    }

    public static void printState() {
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("start");
        SingleTonInitOnDemandHolderIdiomThreadSafe.printState();
        SingleTonInitOnDemandHolderIdiomThreadSafe.getInstance();
//        SingleTonInitOnDemandHolderIdiomThreadSafe.printState();
    }
}
