package infrastructure;

import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Method;
import java.util.*;

public class MiscRunner {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abcdefg");
        try {
            String fd = "     gbb    ";
            System.out.println("try");
            System.out.println(builder.reverse());
            System.out.println(fd.trim() + "!");
            System.out.println(fd + "!");
            System.out.println(fd.replaceAll("bb","aa"));
        }
        finally {
            System.out.println("finally");
        }
        System.out.println("text1");

    Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });

    Thread thread = new Thread(new Runnable() {
        String str = "team";
        public void printt(){
            System.out.println("!");
        }
        @Override
        public void run() {
            printt();
            System.out.println("hallo from " + str);
        }
    });

    thread.start();
//        AbstractCollection

    }
}
