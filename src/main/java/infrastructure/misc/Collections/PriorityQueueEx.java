package infrastructure.misc.Collections;

import infrastructure.misc.Bird;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        Queue<Bird> queue = new PriorityQueue<>(10);

        final Bird e1 = new Bird("1");
        final Bird e2 = new Bird("2");
        queue.offer(e2);
        queue.add(e1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
