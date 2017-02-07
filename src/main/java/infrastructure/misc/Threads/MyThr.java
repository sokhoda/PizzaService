package infrastructure.misc.Threads;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

//@Data
public class MyThr implements Runnable {
    public static final int SIZE = 20;
    private Map<String, Integer> values = new HashMap<>(SIZE);
    private Thread thread2;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern
            ("dd MM yyyy hh:mm:ss");

    private final Object obj;

    public MyThr(Thread thread2, Object obj) {
        this.thread2 = thread2;
        this.obj = obj;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Tread1");
        for (int i = 0; i < SIZE; i++) {
            values.put("A" + i, i);
        }
        LocalDateTime now;
        try {
            while (true) {
                now = LocalDateTime.now();
                if (now.getSecond() % 5 == 0) {
                    System.out.println(Thread.currentThread().getName() +
                            ": thread2.isInterrupted()=" + thread2
                            .isInterrupted());
                    thread2.interrupt();
                    Thread.sleep(2000);
                }
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " Bye!");
        }
    }
}
