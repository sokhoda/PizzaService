package infrastructure.misc.InnerClass;

public class Anonym {
    public static void main(String[] args) {
       new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("Hi!");
            }
        }).start();
    }
}
