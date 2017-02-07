package infrastructure.misc.Threads;

public class ThrRunner {
    public static void main(String[] args) {

        Object obj = new Object();
        Thread thread2 = new Thread(new MyThr2(obj));
        Thread thread1 = new Thread(new MyThr(thread2, obj));

        thread2.start();
        thread1.start();

    }

}
