package infrastructure.misc.InnerClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OuterClass {
    private static final int SIZE = 10;
    private List<Integer> myList = new ArrayList<>(SIZE);

    public OuterClass() {
        for (int i = 0; i < SIZE; i++) {
             myList.add(i);
        }
    }

    public void printContent(){
        MyIterator iterator = new MyIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    private class MyIterator implements Iterator<Integer>{
        private int pos = 0;

        @Override
        public boolean hasNext() {
            return pos <= SIZE - 1;
        }

        @Override
        public Integer next() {
            Integer res = myList.get(pos);
            pos += 2;
            return res;
        }
    }

    public static void main(String[] args) {
        OuterClass calc = new OuterClass();
        calc.printContent();
    }
}
