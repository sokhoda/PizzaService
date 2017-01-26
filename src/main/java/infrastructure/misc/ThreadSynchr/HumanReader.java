package infrastructure.misc.ThreadSynchr;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanReader extends Thread {
    private Bike book;
    private String threadName;

    public HumanReader(String name, Bike book) {
        this.book = book;
        this.threadName = name;
    }

    @Override
    public void run(){
        while (book.getPages() > book.getCurrentPage().get()) {
            book.read();
        }
        synchronized (book) {
            System.out.println(threadName + " finished reading book!");
            book.notify();
        }
    }
}
