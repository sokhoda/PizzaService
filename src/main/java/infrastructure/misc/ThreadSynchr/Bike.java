package infrastructure.misc.ThreadSynchr;

import lombok.Getter;

import java.util.Random;

@Getter
public class Bike {
    private static int maxRead;
    private static Random random = new Random();
    private int pages;
    private ThreadLocal<Integer> currentPage;
    private Thread[] thread = new Thread[2];

    {
        pages = 100;
        maxRead = 100;
        currentPage = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }

    };
        thread[0] = new HumanReader("thread__1", this);
        thread[1] = new HumanReader("thread__2", this);
    }

    public Bike() {
        thread[0].start();
        thread[1].start();
    }

    public int getAlives() {
        int i = 0;
        for (Thread thread1 : thread) {
            if (thread1.isAlive()) i++;
        }
        return i;
    }

    public synchronized void read() {
        try {
            HumanReader current = (HumanReader) Thread.currentThread();
            Integer currentPage = this.currentPage.get();
            System.out.println(current.getThreadName() + " is " +
                    "reading on page=" + currentPage);
            Thread.sleep(1000);
            this.currentPage.set(currentPage + random.nextInt(maxRead));
            System.out.println(current.getThreadName() + " finished reading");
            if (getAlives() > 1) {
                notify();
                System.out.println("Notification sent. 1=" + thread[0].isAlive() +
                        ",2=" + thread[1].isAlive());
                wait();
                System.out.println(current.getThreadName() + " wait");
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
