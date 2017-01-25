package infrastructure.misc.Threads;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

//@Data
public class MyThr2 implements Runnable {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern
            ("dd MM yyyy hh:mm:ss");
    private final Object obj;

    public MyThr2(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        LocalDateTime now;
        Thread.currentThread().setName("Tread2");
        while (true) {
            if (Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() +
                        ":" + ", try isInterrupted=" + Thread
                        .currentThread().isInterrupted());
                System.out.println(LocalDateTime.now().format(formatter));
                try {
                    Thread.sleep(4000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(Thread.currentThread().getName() + " bye!");
    }
}
