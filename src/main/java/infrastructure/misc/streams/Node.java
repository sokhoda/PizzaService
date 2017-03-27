package infrastructure.misc.streams;

import java.util.function.Supplier;

public class Node {
    private int previous = 0;
    private int current = 1;

    public Supplier<Node> value = () ->
    {
     int res = previous + current;
        previous = current;
        current = res;
        return this;
    };

    public Node() {
    }

    @Override
    public String toString() {
        return "(" + previous +
                ", " + current + "), \n";
    }
}
